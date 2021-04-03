package payroll.core;

import java.util.HashMap;
import java.util.Map;

public class MemoryPayrollDatabase implements PayrollDatabase {
    private Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.put(employee.getEmpId(), employee);
    }

    @Override
    public Employee getEmployee(int empId) {
        return employees.get(empId);
    }
}
