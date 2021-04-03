package payroll.core;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private final String name;

    public ChangeNameTransaction(int empId, String name, PayrollDatabase database) {
        super(empId, database);
        this.name = name;
    }

    protected void change(Employee employee) {
        employee.setName(name);
    }
}
