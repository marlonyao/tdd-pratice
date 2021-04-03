package payroll.core;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private final double hourlyRate;

    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate, PayrollDatabase payrollDatabase) {
        super(empId, name, address, payrollDatabase);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected HourlyClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    protected WeeklySchedule getSchedule() {
        return new WeeklySchedule();
    }
}
