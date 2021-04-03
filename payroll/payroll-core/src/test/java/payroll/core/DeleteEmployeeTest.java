package payroll.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteEmployeeTest {
    @Test
    public void should_delete_employee() {
        int empId = 1;
        PayrollDatabase payrollDatabase = new MemoryPayrollDatabase();
        payrollDatabase.addEmployee(EmployeeMother.salaried(empId));

        DeleteEmployeeTransaction transaction = new DeleteEmployeeTransaction(empId, payrollDatabase);
        transaction.execute();

        assertThat(payrollDatabase.getEmployee(empId)).isNull();
    }
}
