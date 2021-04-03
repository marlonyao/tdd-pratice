package payroll.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class AddTimeCardTest {

    private int empId;
    private LocalDate date;
    private double hours;
    private PayrollDatabase database;
    private AddTimeCardTransaction transaction;

    @BeforeEach
    void setUp() {
        empId = 1;
        date = LocalDate.of(2020, 12, 20);
        hours = 7.0;
        database = new MemoryPayrollDatabase();
        transaction = new AddTimeCardTransaction(empId, date, hours, database);
    }
    
    @Test
    public void should_throw_exception_given_employee_not_exist() {
        assertThatThrownBy(() -> transaction.execute())
                .isInstanceOf(ApplicationException.class)
                .hasMessage("No such employee with id: " + empId);
    }

    @Test
    public void should_throw_exception_given_not_hourly_employee() {
        database.addEmployee(createSalariedEmployee(empId));

        assertThatThrownBy(() -> transaction.execute())
                .isInstanceOf(ApplicationException.class)
                .hasMessage("Tried to add timecard to non-hourly employee");
    }

    @Test
    public void should_add_time_card() {
        database.addEmployee(createHourlyEmployee(empId));

        transaction.execute();

        Employee employee = database.getEmployee(empId);
        HourlyClassification classification = (HourlyClassification) employee.getClassification();
        assertThat(classification.getTimeCard(date).getHours()).isCloseTo(7.0, offset(0.01));
    }

    private Employee createHourlyEmployee(int empId) {
        return new Employee(empId, "Bob", "Home")
                .setClassification(new HourlyClassification(10.0))
                .setSchedule(new WeeklySchedule())
                .setMethod(new HoldMethod());
    }

    private Employee createSalariedEmployee(int empId) {
        return new Employee(empId, "Bob", "Home")
                .setClassification(new SalariedClassification(1000))
                .setSchedule(new MonthlySchedule())
                .setMethod(new HoldMethod());
    }
}
