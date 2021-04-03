package payroll.core;

public abstract class ChangeEmployeeTransaction extends Transaction {
    protected final int empId;
    protected final PayrollDatabase database;

    public ChangeEmployeeTransaction(int empId, PayrollDatabase database) {
        this.empId = empId;
        this.database = database;
    }

    @Override
    public void execute() {
        Employee employee = database.getEmployee(empId);
        if (employee == null) {
            throw new ApplicationException("No such employee: empId=" + empId);
        }
        change(employee);
    }

    protected abstract void change(Employee employee);
}
