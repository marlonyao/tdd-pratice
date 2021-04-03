package payroll.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class AddEmployeeTest {
    @Test
    public void should_add_salaried_employee() {
        PayrollDatabase payrollDatabase = new MemoryPayrollDatabase();
        int empId = 1;
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
}
