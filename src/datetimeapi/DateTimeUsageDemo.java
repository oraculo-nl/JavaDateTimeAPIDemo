package datetimeapi;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateTimeUsageDemo {
    public static void main(String[] args) {
        get();
        is();
        withUntil();
        plus();
        minus();
        to();
        at();
        temporalAdjusters();
    }


    private static void at() {
        var l = LocalDate.of(1800,1,1);
        System.out.println("atTime: "+l.atTime(OffsetTime.of(5,0,0,0, ZoneOffset.UTC )));
    }

    private static void to() {
        var l = LocalDate.of(1971,1,1);
        System.out.println("toEpochDay: "+l.toEpochDay());

    }

    private static void minus() {
        var l = LocalDate.of(1200,1,1);
        System.out.println("minus: "+l.minusWeeks(180));
    }

    private static void plus() {
        var l = LocalDate.of(1200,1,1);
        System.out.println("plus: "+l.plusMonths(28));
    }

    public static void get() {
        var i = Instant.now();
        System.out.println("Millisecond: " + i.get(ChronoField.MILLI_OF_SECOND));
        var l = LocalDateTime.now();
        System.out.println("Day of the month: " + l.get(ChronoField.DAY_OF_MONTH));
    }

    public static void is() {
        var i = Instant.now();
        System.out.println("Instant after? " + i.isAfter(Instant.parse("1980-04-09T10:15:30.00Z")));
        var l = LocalDateTime.now();
        System.out.println("LocalDateTime before?: " + l.isBefore(LocalDateTime.ofInstant(i, ZoneId.systemDefault())));
    }

    public static void withUntil() {
        var i = Instant.now();
        System.out.println("Instant with? " + i.with(ChronoField.MILLI_OF_SECOND,22));
        var l = LocalDateTime.now();
        System.out.println("LocalDateTime with? " + l.with(DayOfWeek.FRIDAY));
        System.out.println("LocalDateTime with? " + l.withYear(1920));
        System.out.println("Decades until? " + l.until(LocalDateTime.of(2100,1,1,0,0,0), ChronoUnit.DECADES));
    }

    private static void temporalAdjusters() {
        System.out.println(TemporalAdjusters.firstDayOfMonth().adjustInto(LocalDateTime.now()));
        System.out.println(TemporalAdjusters.firstDayOfNextYear().adjustInto(LocalDateTime.now()));
        System.out.println(TemporalAdjusters.firstDayOfYear().adjustInto(LocalDateTime.now()));
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println(localDate.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY )));
    }

}
