package datetimeapi;

import java.time.*;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DatesAndTimesDemo {
    static Instant instant;

    public static void main(String[] args) {
        instantEpoch();
        instantDemo();
        localDateDemo();
        localTimeDemo();
        localDateTimeDemo();
        ZonedDateTimeDemo();
    }

    private static void instantEpoch() {
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(-1_000_00), ZoneId.of("UTC")));
        System.out.println(LocalDateTime.ofInstant(Instant.now().minus(Period.ofDays(1375)), ZoneId.systemDefault()));
        System.out.println(LocalDateTime.parse("2017-12-16T18:43:48.446774").toInstant(ZoneOffset.UTC).getEpochSecond());
    }

    public static void instantDemo() {
        Instant instant1 = Instant.now();
        System.out.println("Instant1: " + instant1);

        Instant instant2 = Instant.now(Clock.systemUTC());
        System.out.println("Instant2: " + instant2);

        long now = System.currentTimeMillis();
        Instant instant3 = Instant.ofEpochMilli(now);
        System.out.println("Instant3: " + instant3);

        now = now / 1000;
        Instant instant4 = Instant.ofEpochSecond(now);
        System.out.println("Instant4: " + instant4);

        Instant instant5 = Instant.ofEpochSecond(now, 345000000);
        System.out.println("Instant5: " + instant5);

        Instant instant6 = Instant.parse("1980-04-09T10:15:30.00Z");
        System.out.println("Instant6: " + instant6);

        //conversion from java.util.Date
        now = System.currentTimeMillis();
        Date date = new Date(now);
        instant = date.toInstant();
        System.out.println("instant: " + instant);
    }

    public static void localDateDemo() {
        LocalDate localDate1 = LocalDate.now();
        System.out.println("LocalDate1: " + localDate1);

        LocalDate localDate2 = LocalDate.now(Clock.systemUTC());
        System.out.println("LocalDate2: " + localDate2);

        LocalDate localDate3 = LocalDate.now(ZoneId.systemDefault());
        System.out.println("LocalDate3: " + localDate3);

        LocalDate localDate4 = LocalDate.of(1980, 4, 9);
        System.out.println("LocalDate4: " + localDate4);

        LocalDate localDate5 = LocalDate.of(1980, Month.APRIL, 9);
        System.out.println("LocalDate5: " + localDate5);

        LocalDate localDate6 = LocalDate.ofEpochDay(3629);
        System.out.println("LocalDate6: " + localDate6);

        LocalDate localDate7 = LocalDate.ofYearDay(1997, 127);
        System.out.println("LocalDate7: " + localDate7);

        LocalDate localDate8 = LocalDate.parse("2018-07-24");
        System.out.println("LocalDate8: " + localDate8);

        LocalDate localDate9 = LocalDate.parse("20180724", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("LocalDate9: " + localDate9);

        LocalDate localDate10 = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("LocalDate10: " + localDate10);

    }

    public static void localTimeDemo() {
        LocalTime localTime1 = LocalTime.now();
        System.out.println("LocalTime1: " + localTime1);

        LocalTime localTime2 = LocalTime.now(Clock.systemUTC());
        System.out.println("LocalTime2: " + localTime2);

        LocalTime localTime3 = LocalTime.now(ZoneId.systemDefault());
        System.out.println("LocalTime3: " + localTime3);

        LocalTime localTime4 = LocalTime.of(18, 4);
        System.out.println("LocalTime4: " + localTime4);

        LocalTime localTime5 = LocalTime.of(18, 4, 9);
        System.out.println("LocalTime5: " + localTime5);

        LocalTime localTime6 = LocalTime.ofNanoOfDay(3629);
        System.out.println("LocalTime6: " + localTime6);

        LocalTime localTime7 = LocalTime.ofSecondOfDay(19977);
        System.out.println("LocalTime7: " + localTime7);

        LocalTime localTime8 = LocalTime.parse("10:15");
        System.out.println("LocalTime8: " + localTime8);

        LocalTime localTime9 = LocalTime.parse("10:15:30+01:00", DateTimeFormatter.ISO_TIME);
        System.out.println("LocalTime9: " + localTime9);

    }

    public static void localDateTimeDemo() {
        LocalDateTime localDT1 = LocalDateTime.now();
        System.out.println("LocalDateTime1 : " + localDT1);


        LocalDateTime localDT2 = LocalDateTime.now(Clock.systemUTC());
        System.out.println("LocalDateTime2 : " + localDT2);

        LocalDateTime localDT3 = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println("LocalDateTime3 : " + localDT3);

        LocalDateTime localDT4 = LocalDateTime.of(1980, 4, 9, 20, 15);
        System.out.println("LocalDateTime4 : " + localDT4);

        LocalDateTime localDT5 = LocalDateTime.of(1980, Month.APRIL, 9, 20, 15);
        System.out.println("LocalDateTime5 : " + localDT5);

        LocalDateTime localDT6 = LocalDateTime.of(1979, 12, 9, 18, 5, 50);
        System.out.println("LocalDateTime6 : " + localDT6);

        LocalDateTime localDT7 = LocalDateTime.of(1979, Month.DECEMBER, 9, 18, 5, 50);
        System.out.println("LocalDateTime7 : " + localDT7);

        LocalDateTime localDT8 = LocalDateTime.of(1983, 7, 12, 20, 15, 50, 345678900);
        System.out.println("LocalDateTime8 : " + localDT8);

        LocalDateTime localDT9 = LocalDateTime.of(1983, Month.JULY, 12, 20, 15, 50, 345678900);
        System.out.println("LocalDateTime9 : " + localDT9);

        LocalDateTime localDT10 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 50));
        System.out.println("LocalDateTime10: " + localDT10);

        LocalDateTime localDT11 = LocalDateTime.ofEpochSecond(1555552018, 456789500, ZoneOffset.UTC);
        System.out.println("LocalDateTime11: " + localDT11);

        LocalDateTime localDT12 = LocalDateTime.ofInstant(Instant.ofEpochMilli(324142255123L), ZoneId.systemDefault());
        System.out.println("LocalDateTime12: " + localDT12);

        LocalDateTime localDT13 = LocalDateTime.parse("1945-08-17T10:20:45");
        System.out.println("LocalDateTime13: " + localDT13);

        LocalDateTime localDT14 = LocalDateTime.parse("20190824155025", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println("LocalDateTime14: " + localDT14);
    }

    public static void ZonedDateTimeDemo() {
        ZonedDateTime zonedDT1 = ZonedDateTime.now();
        System.out.println("ZonedDateTime1 : " + zonedDT1);

        ZonedDateTime zonedDT2 = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("ZonedDateTime2 : " + zonedDT2);

        ZonedDateTime zonedDT3 = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("ZonedDateTime3 : " + zonedDT3);

        ZonedDateTime zonedDT4 = ZonedDateTime.of(1980, 4, 9, 20, 15, 0, 0, ZoneId.systemDefault());
        System.out.println("ZonedDateTime4 : " + zonedDT4);

        ZonedDateTime zonedDT5 = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault());
        System.out.println("ZonedDateTime5 : " + zonedDT5);

        ZonedDateTime zonedDT6 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        System.out.println("ZonedDateTime6 : " + zonedDT6);

        ZonedDateTime zonedDT7 = ZonedDateTime.ofLocal(LocalDateTime.now(), ZoneId.systemDefault(), ZoneOffset.UTC);
        System.out.println("ZonedDateTime7: " + zonedDT7);

        ZonedDateTime zonedDT8 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(324142255123L), ZoneId.systemDefault());
        System.out.println("ZonedDateTime8: " + zonedDT8);

        ZonedDateTime zonedDT9 = ZonedDateTime.parse("1945-08-17T10:20:45+01:00[Europe/Paris]");
        System.out.println("ZonedDateTime9: " + zonedDT9);

        ZonedDateTime zonedDT10 = ZonedDateTime.parse("20190824155025GMT+8", DateTimeFormatter.ofPattern("yyyyMMddHHmmssO"));
        System.out.println("ZonedDateTime10: " + zonedDT10);

    }

}
