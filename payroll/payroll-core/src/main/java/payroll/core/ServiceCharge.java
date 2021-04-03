package payroll.core;

import java.time.LocalDate;

public class ServiceCharge {
    private final LocalDate date;
    private final double amount;

    public ServiceCharge(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
