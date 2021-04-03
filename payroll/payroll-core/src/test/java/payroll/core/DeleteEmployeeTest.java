package payroll.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteEmployeeTest {
    @Test
    public void should_delete_employee() {
        int empId = 1;
        PayrollDatabase payrollDatabase = new MemoryPayrollDatabase();
        payrollDatabase.addEmployee(createSalariedEmployee(empId));

        DeleteEmployeeTransaction transaction = new DeleteEmployeeTransaction(empId, payrollDatabase);
        transaction.execute();

        assertThat(payrollDatabase.getEmployee(empId)).isNull();
    }

    private Employee createSalariedEmployee(int empId) {
        return new Employee(empId, "Bob", "Home")
                .setClassification(new SalariedClassification(1000))
                .setSchedule(new MonthlySchedule())
                .setMethod(new HoldMethod());
    }
}
