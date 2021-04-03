package payroll.core;

import java.time.LocalDate;

public class AddSalesReceiptTransaction extends Transaction {
    private final int empId;
    private final LocalDate date;
    private final double amount;
    private final PayrollDatabase database;

    public AddSalesReceiptTransaction(int empId, LocalDate date, double amount, PayrollDatabase database) {
        this.empId = empId;
        this.date = date;
        this.amount = amount;
        this.database = database;
    }

    @Override
    public void execute() {
        Employee employee = database.getEmployee(empId);
        if (employee == null) {
            throw new ApplicationException("No such employee with id: " + empId);
        }
        if (!(employee.getClassification() instanceof CommissionedClassification)) {
            throw new ApplicationException("Tried to add sales receipt to non-commissioned employee");
        }
        CommissionedClassification classification = (CommissionedClassification) employee.getClassification();
        classification.addSalesReceipt(new SalesReceipt(date, amount));
    }
}
