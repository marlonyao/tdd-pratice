package payroll.core;

public class EmployeeMother {
    public static Employee hourly(int empId) {
        return create(empId)
                .setClassification(new HourlyClassification(10.0))
                .setSchedule(new WeeklySchedule());
    }

    public static Employee salaried(int empId) {
        return create(empId)
                .setClassification(new SalariedClassification(1000))
                .setSchedule(new MonthlySchedule());
    }

    public static Employee commissioned(int empId) {
        return create(empId)
                .setClassification(new CommissionedClassification(1000, 10.0))
                .setSchedule(new BiweeklySchedule());
    }

    private static Employee create(int empId) {
        return new Employee(empId, "Bob", "Home")
                .setMethod(new HoldMethod())
                .setAffiliation(new NoAffiliation());
    }
}
