package payroll.core;

public class AddSalariedEmployee {
    private final int empId;
    private final String name;
    private final String address;
    private final double salary;
    private PayrollDatabase payrollDatabase;

    public AddSalariedEmployee(int empId, String name, String address, double salary, PayrollDatabase payrollDatabase) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.payrollDatabase = payrollDatabase;
    }

    public void execute() {
        Employee employee = new Employee(empId, name, address);
        employee.setClassification(new SalariedClassification(salary));
        employee.setSchedule(new MonthlySchedule());
        employee.setMethod(new HoldMethod());
        payrollDatabase.addEmployee(employee);
    }
}
