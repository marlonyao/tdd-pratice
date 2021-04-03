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

    @Override
    public void deleteEmployee(int empId) {
        employees.remove(empId);
    }

    @Override
    public Employee getEmployeeByMemberId(int memberId) {
        return employees.values().stream().filter(e -> {
            Affiliation affiliation = e.getAffiliation();
            return (affiliation instanceof UnionAffiliation)
                    && ((UnionAffiliation) affiliation).getMemberId() == memberId;
        }).findFirst().orElse(null);
    }

    public void clear() {
        employees.clear();
    }
}
