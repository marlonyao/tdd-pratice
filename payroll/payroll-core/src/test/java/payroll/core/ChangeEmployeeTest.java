package payroll.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ChangeEmployeeTest {
    private int empId;
    private MemoryPayrollDatabase database;

    @BeforeEach
    void setUp() {
        empId = 1;
        database = new MemoryPayrollDatabase();
    }

    @Test
    public void should_change_name() {
        database.addEmployee(EmployeeMother.hourly(empId));
        ChangeNameTransaction transaction = new ChangeNameTransaction(empId, "Bill", database);
        transaction.execute();

        Employee employee = database.getEmployee(empId);
        assertThat(employee.getName()).isEqualTo("Bill");
    }
    
    @Test
    public void should_change_name_throw_exception_given_employee_not_exist() {
        ChangeNameTransaction transaction = new ChangeNameTransaction(empId, "Bill", database);
        assertThatThrownBy(transaction::execute)
                .isInstanceOf(ApplicationException.class)
                .hasMessage("No such employee: empId=1");
    }
    
    @Test
    public void should_change_address() {
        database.addEmployee(EmployeeMother.hourly(empId));
        ChangeAddressTransaction transaction = new ChangeAddressTransaction(empId, "NewHome", database);
        transaction.execute();

        Employee employee = database.getEmployee(empId);
        assertThat(employee.getAddress()).isEqualTo("NewHome");
    }
    
    @Test
    public void should_change_hourly_rate() {
        database.addEmployee(EmployeeMother.hourly(empId));
        ChangeHourlyRateTransaction transaction = new ChangeHourlyRateTransaction(empId, 5.67, database);
        transaction.execute();

        Employee employee = database.getEmployee(empId);
        assertThat(((HourlyClassification)employee.getClassification()).getHourlyRate())
                .isCloseTo(5.67, offset(0.01));
    }
}
