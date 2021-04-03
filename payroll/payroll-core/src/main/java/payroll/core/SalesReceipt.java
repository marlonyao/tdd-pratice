package payroll.core;

import java.time.LocalDate;

public class SalesReceipt {
    private final LocalDate date;
    private final double amount;

    public SalesReceipt(LocalDate date, double amount) {
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
