package payroll.core;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
    private final String address;

    public ChangeAddressTransaction(int empId, String address, PayrollDatabase database) {
        super(empId, database);
        this.address = address;
    }

    @Override
    protected void change(Employee employee) {
        employee.setAddress(address);
    }
}
