package payroll.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class AddServiceChargeTest {

    private int memberId;
    private int empId;
    private double amount;
    private LocalDate date;
    private PayrollDatabase database;
    private AddServiceChargeTransaction transaction;

    @BeforeEach
    void setUp() {
        memberId = 11;
        empId = 1;
        amount = 123.0;
        date = LocalDate.of(2020, 12, 20);
        database = new MemoryPayrollDatabase();
        transaction = new AddServiceChargeTransaction(memberId, date, amount, database);
    }

    @Test
    public void should_add_service_charge() {
        database.addEmployee(EmployeeMother.hourly(empId)
                .setAffiliation(new UnionAffiliation(memberId, 5.0)));

        transaction.execute();

        Employee employee = database.getEmployee(empId);
        UnionAffiliation affiliation = (UnionAffiliation) employee.getAffiliation();
        assertThat(affiliation.getServiceChange(date).getAmount()).isCloseTo(123.0, offset(0.01));
    }
    
    @Test
    public void should_throw_exception_given_not_a_member() {
        database.addEmployee(EmployeeMother.hourly(empId));

        assertThatThrownBy(() -> transaction.execute())
                .isInstanceOf(ApplicationException.class)
                .hasMessage("Member invalid: id=11");
    }
}
