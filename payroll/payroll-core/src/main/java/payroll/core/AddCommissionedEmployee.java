package payroll.core;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private final double salary;
    private final double commissionRate;

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionRate, PayrollDatabase payrollDatabase) {
        super(empId, name, address, payrollDatabase);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
