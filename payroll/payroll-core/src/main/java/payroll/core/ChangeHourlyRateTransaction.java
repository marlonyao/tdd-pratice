package payroll.core;

public class ChangeHourlyRateTransaction extends ChangeEmployeeTransaction {
    private double hourlyRate;

    public ChangeHourlyRateTransaction(int empId, double hourlyRate, MemoryPayrollDatabase database) {
        super(empId, database);
        this.hourlyRate = hourlyRate;
    }


    @Override
    protected void change(Employee employee) {
        HourlyClassification classification = (HourlyClassification) employee.getClassification();
        classification.setHourlyRate(hourlyRate);
    }
}
