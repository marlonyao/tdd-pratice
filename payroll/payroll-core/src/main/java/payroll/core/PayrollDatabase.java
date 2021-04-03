package payroll.core;

public interface PayrollDatabase {
    void addEmployee(Employee employee);

    Employee getEmployee(int empId);

    void deleteEmployee(int empId);
}
