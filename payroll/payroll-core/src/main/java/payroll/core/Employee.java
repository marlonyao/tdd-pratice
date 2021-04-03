package payroll.core;

public class Employee {
    private final Integer empId;
    private final String name;
    private final String address;
    private PaymentClassification classification;
    private PaymentSchedule schedule;
    private PaymentMethod method;
    private Affiliation affiliation;

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

    public Employee setClassification(PaymentClassification classification) {
        this.classification = classification;
        return this;
    }

    public PaymentClassification getClassification() {
        return classification;
    }

    public Employee setSchedule(PaymentSchedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public PaymentSchedule getSchedule() {
        return schedule;
    }

    public Employee setMethod(PaymentMethod method) {
        this.method = method;
        return this;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public Employee setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
        return this;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }
}
