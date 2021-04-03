package payroll.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class AddSalesReceiptTest {

    private int empId;
    private LocalDate date;
    private double amount;
    private PayrollDatabase database;
    private AddSalesReceiptTransaction transaction;

    @BeforeEach
    void setUp() {
        empId = 1;
        date = LocalDate.of(2020, 12, 20);
        amount = 123.0;
        database = new MemoryPayrollDatabase();
        transaction = new AddSalesReceiptTransaction(empId, date, amount, database);
    }

    @Test
    public void should_add_sales_receipt() {
        database.addEmployee(EmployeeMother.commissioned(empId));

        transaction.execute();

        Employee employee = database.getEmployee(empId);
        CommissionedClassification classification = (CommissionedClassification) employee.getClassification();
        assertThat(classification.getSalesReceipt(date).getAmount()).isCloseTo(123.0, offset(0.01));
    }

    @Test
    public void should_throw_exception_given_employee_not_exist() {
        assertThatThrownBy(() -> transaction.execute())
                .isInstanceOf(ApplicationException.class)
                .hasMessage("No such employee with id: 1");
    }

    @Test
    public void should_throw_exception_given_not_commissioned_employee() {
        database.addEmployee(EmployeeMother.salaried(empId));

        assertThatThrownBy(() -> transaction.execute())
                .isInstanceOf(ApplicationException.class)
                .hasMessage("Tried to add sales receipt to non-commissioned employee");
    }
}
