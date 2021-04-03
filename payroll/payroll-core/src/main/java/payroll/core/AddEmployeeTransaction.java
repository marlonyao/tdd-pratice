package payroll.core;

public abstract class AddEmployeeTransaction {
    protected final int empId;
    protected final String name;
    protected final String address;
    protected PayrollDatabase payrollDatabase;

    public AddEmployeeTransaction(int empId, String name, String address, PayrollDatabase payrollDatabase) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.payrollDatabase = payrollDatabase;
    }

    public void execute() {
        Employee employee = new Employee(empId, name, address);
        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
        employee.setMethod(new HoldMethod());
        payrollDatabase.addEmployee(employee);
    }

    protected abstract PaymentClassification getClassification();

    protected abstract PaymentSchedule getSchedule();
}
