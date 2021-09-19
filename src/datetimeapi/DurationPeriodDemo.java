package datetimeapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DurationPeriodDemo {
    public static void main(String[] args) {
        durationDemo();
        periodDemo();
    }

    /**
     * Duration models a quantity or amount of time in terms of seconds and nanoseconds. It can be accessed using other
     * duration-based units, such as minutes and hours. In addition, the DAYS unit can be used and is treated as exactly
     * equal to 24 hours
     */
    public static void durationDemo() {
        Duration duration1 = Duration.ofDays(7);
        System.out.println("Duration1: " + duration1);
        Duration duration2 = Duration.ofHours(8);
        System.out.println("Duration2: " + duration2);
        Duration duration3 = Duration.ofMinutes(15);
        System.out.println("Duration3: " + duration3);
        Duration duration4 = Duration.ofSeconds(10);
        System.out.println("Duration4: " + duration4);
        Duration duration5 = Duration.ofSeconds(30, 123456789);
        System.out.println("Duration5: " + duration5);
        Duration duration6 = Duration.parse("P1DT8H15M10.345000S");
        System.out.println("Duration6: " + duration6);
        Duration duration7 = Duration.between(LocalDateTime.of(2019, 1, 1, 0, 0), LocalDateTime.now());
        System.out.println("Duration7: " + duration7);
    }

    /**
     * Period models a quantity or amount of time in terms of years, months and days
     */
    public static void periodDemo() {
        Period period1 = Period.of(1, 6, 10);
        System.out.println("Period1: " + period1);
        Period period2 = Period.ofDays(15);
        System.out.println("Period2: " + period2);
        Period period3 = Period.ofWeeks(15);
        System.out.println("Period3: " + period3);
        Period period4 = Period.ofMonths(3);
        System.out.println("Period4: " + period4);
        Period period5 = Period.ofYears(5);
        System.out.println("Period5: " + period5);
        Period period6 = Period.parse("P5Y3M15D");
        System.out.println("Period6: " + period6);
        Period period7 = Period.between(LocalDate.of(1979, 12, 9), LocalDate.of(1980, 4, 9));
        System.out.println("Period7: " + period7);
    }
}
