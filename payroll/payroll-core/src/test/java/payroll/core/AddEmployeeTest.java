package payroll.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class AddEmployeeTest {
    private PayrollDatabase payrollDatabase;
    private int empId;

    @BeforeEach
    void setUp() {
        payrollDatabase = new MemoryPayrollDatabase();
        empId = 1;
    }

    @Test
    public void should_add_salaried_employee() {
        AddSalariedEmployee transaction = new AddSalariedEmployee(empId, "Bob", "Home", 1000, payrollDatabase);
        transaction.execute();

        Employee employee = payrollDatabase.getEmployee(empId);
        assertThat(employee.getName()).isEqualTo("Bob");
        assertThat(employee.getAddress()).isEqualTo("Home");

        assertThat(employee.getClassification()).isInstanceOf(SalariedClassification.class);
        SalariedClassification classification = (SalariedClassification) employee.getClassification();
        assertThat(classification.getSalary()).isCloseTo(1000, offset(0.01));

        assertThat(employee.getSchedule()).isInstanceOf(MonthlySchedule.class);

        assertThat(employee.getMethod()).isInstanceOf(HoldMethod.class);
    }
    
    @Test
    public void should_add_hourly_employee() {
        AddHourlyEmployee transaction = new AddHourlyEmployee(empId, "Bob", "Home", 100.0, payrollDatabase);
        transaction.execute();

        Employee employee = payrollDatabase.getEmployee(empId);
        assertThat(employee.getName()).isEqualTo("Bob");
        assertThat(employee.getAddress()).isEqualTo("Home");

        assertThat(employee.getClassification()).isInstanceOf(HourlyClassification.class);
        HourlyClassification classification = (HourlyClassification) employee.getClassification();
        assertThat(classification.getHourlyRate()).isCloseTo(100, offset(0.01));

        assertThat(employee.getSchedule()).isInstanceOf(WeeklySchedule.class);

        assertThat(employee.getMethod()).isInstanceOf(HoldMethod.class);
    }

    @Test
    public void should_add_commissioned_employee() {
        AddCommissionedEmployee transaction = new AddCommissionedEmployee(empId, "Bob", "Home", 1000, 100, payrollDatabase);
        transaction.execute();

        Employee employee = payrollDatabase.getEmployee(empId);
        assertThat(employee.getName()).isEqualTo("Bob");
        assertThat(employee.getAddress()).isEqualTo("Home");

        assertThat(employee.getClassification()).isInstanceOf(CommissionedClassification.class);
        CommissionedClassification classification = (CommissionedClassification) employee.getClassification();
        assertThat(classification.getSalary()).isCloseTo(1000, offset(0.01));
        assertThat(classification.getCommissionRate()).isCloseTo(100, offset(0.01));

        assertThat(employee.getSchedule()).isInstanceOf(BiweeklySchedule.class);

        assertThat(employee.getMethod()).isInstanceOf(HoldMethod.class);
    }
}
