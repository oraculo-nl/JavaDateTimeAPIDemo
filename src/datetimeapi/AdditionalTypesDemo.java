package datetimeapi;

import java.time.*;

public class AdditionalTypesDemo {
    public static void main(String[] args) {
        //Month month-of-year in isolation, such as 'DECEMBER'.
        Month month = Month.of(3);
        System.out.println(month);
        //DayOfWeek single day-of-week in isolation, such as 'TUESDAY'.
        LocalDate today = LocalDate.now();
        System.out.println(today.getDayOfWeek());             // SUNDAY
        System.out.println(today.getDayOfWeek()
                .getValue());  //7
        DayOfWeek dayOfWeek = DayOfWeek.of(1);
        System.out.println("dayOfWeek = " + dayOfWeek);
        dayOfWeek = DayOfWeek.valueOf("SATURDAY");
        System.out.println("dayOfWeek = " + dayOfWeek);
        //Year a single year in isolation, such as '2010'.
        Year y = Year.now();
        System.out.println(y);
        LocalDate l = y.atDay(123);
        System.out.println(l);
        //YearMonth e.g. could be used for a credit card expiry, such as '2010-12'
        YearMonth ym = YearMonth.now();
        System.out.println(ym);
        YearMonth year = YearMonth.of(2017, 12);
        System.out.println(year);
        //MonthDay could be used to store an annual event like a birthday
        MonthDay m = MonthDay.now();
        LocalDate date = m.atYear(1994);
        System.out.println(date);
        boolean b = m.isValidYear(2012);
        System.out.println(b);
        //OffsetTime
        OffsetTime offsetTime1 = OffsetTime.now();
        System.out.println("OffsetTime1: " + offsetTime1);
        OffsetTime offsetTime3 = OffsetTime.now(ZoneId.of("Asia/Jakarta"));
        System.out.println("OffsetTime2: " + offsetTime3);
        OffsetTime t = OffsetTime.of(LocalTime.MIDNIGHT, ZoneOffset.of("+08"));
        System.out.println("OffsetTime3: " + t);
        t = OffsetTime.ofInstant(Instant.now(), ZoneId.of("America/New_York"));
        System.out.println("OffsetTime4: " + t);
        //OffsetDateTime
        OffsetDateTime offsetDT1 = OffsetDateTime.now();
        System.out.println("OffsetDateTime1: " + offsetDT1);
        OffsetDateTime offsetDT2 = OffsetDateTime.ofInstant(Instant.now(), ZoneId.of("America/New_York"));
        System.out.println("OffsetDateTime2: " + offsetDT2);

    }
}
