package payroll.core;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommissionedClassification extends PaymentClassification {
    private final double salary;
    private final double commissionRate;
    private Map<LocalDate, SalesReceipt> salesReceiptMap = new LinkedHashMap<>();

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public double getSalary() {
        return salary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public CommissionedClassification addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceiptMap.put(salesReceipt.getDate(), salesReceipt);
        return this;
    }

    public SalesReceipt getSalesReceipt(LocalDate date) {
        return salesReceiptMap.get(date);
    }
}
