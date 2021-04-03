package payroll.core;

public interface PayrollDatabase {
    void addEmployee(Employee employee);

    Employee getEmployee(int empId);
}
