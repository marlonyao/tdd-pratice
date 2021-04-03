package payroll.core;

import java.util.Objects;

public class Employee {
    private final Integer empId;
    private final String name;
    private final String address;
    private PaymentClassification classification;
    private PaymentSchedule schedule;
    private PaymentMethod method;

    public Employee(Integer empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setClassification(PaymentClassification classification) {
        this.classification = classification;
    }

    public PaymentClassification getClassification() {
        return classification;
    }

    public void setSchedule(PaymentSchedule schedule) {
        this.schedule = schedule;
    }

    public PaymentSchedule getSchedule() {
        return schedule;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentMethod getMethod() {
        return method;
    }
}
