package payroll.core;

import java.time.LocalDate;

public class AddTimeCardTransaction extends Transaction {
    private final int empId;
    private final LocalDate date;
    private final double hours;
    private final PayrollDatabase database;

    public AddTimeCardTransaction(int empId, LocalDate date, double hours, PayrollDatabase database) {
        this.empId = empId;
        this.date = date;
        this.hours = hours;
        this.database = database;
    }

    @Override
    public void execute() {
        Employee employee = database.getEmployee(empId);
        if (employee == null) {
            throw new ApplicationException("No such employee with id: " + empId);
        }
        if (!(employee.getClassification() instanceof HourlyClassification)) {
            throw new ApplicationException("Tried to add timecard to non-hourly employee");
        }
        HourlyClassification classification = (HourlyClassification) employee.getClassification();
        classification.addTimeCard(new TimeCard(date, hours));
    }
}
