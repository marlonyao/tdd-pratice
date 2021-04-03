package payroll.core;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {
    private double hourlyRate;
    private Map<LocalDate, TimeCard> timeCards = new LinkedHashMap<>();

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public HourlyClassification setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        return this;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public HourlyClassification addTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.getDate(), timeCard);
        return this;
    }

    public TimeCard getTimeCard(LocalDate date) {
        return timeCards.get(date);
    }

}
