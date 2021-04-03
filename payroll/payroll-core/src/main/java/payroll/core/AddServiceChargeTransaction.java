package payroll.core;

import java.time.LocalDate;

public class AddServiceChargeTransaction extends Transaction {
    private final int memberId;
    private final LocalDate date;
    private final double amount;
    private final PayrollDatabase database;

    public AddServiceChargeTransaction(int memberId, LocalDate date, double amount, PayrollDatabase database) {
        this.memberId = memberId;
        this.date = date;
        this.amount = amount;
        this.database = database;
    }

    @Override
    public void execute() {
        Employee employee = database.getEmployeeByMemberId(memberId);
        if (employee == null) {
            throw new ApplicationException("Member invalid: id=" + memberId);
        }
        UnionAffiliation affiliation = (UnionAffiliation) employee.getAffiliation();
        affiliation.addServiceCharge(new ServiceCharge(date, amount));
    }
}
