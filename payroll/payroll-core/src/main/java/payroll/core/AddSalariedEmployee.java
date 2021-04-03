package payroll.core;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private final double salary;

    public AddSalariedEmployee(int empId, String name, String address, double salary, PayrollDatabase payrollDatabase) {
        super(empId, name, address, payrollDatabase);
        this.salary = salary;
    }

    @Override
    protected MonthlySchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected SalariedClassification getClassification() {
        return new SalariedClassification(salary);
    }
}
