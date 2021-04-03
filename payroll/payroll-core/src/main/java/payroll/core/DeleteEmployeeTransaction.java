package payroll.core;

public class DeleteEmployeeTransaction extends Transaction {
    private int empId;
    private PayrollDatabase payrollDatabase;

    public DeleteEmployeeTransaction(int empId, PayrollDatabase payrollDatabase) {
        this.empId = empId;
        this.payrollDatabase = payrollDatabase;
    }

    @Override
    public void execute() {
        payrollDatabase.deleteEmployee(empId);
    }
}
