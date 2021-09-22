package datetimeapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormattingDemo {
    public static void main(String[] args) {
        /*
        yy
        yyyy

        MM
        MMM
        MMMM

        d
        dd

        e
        ee
        eee
        eeee

        E
        EE
        EEE
        EEEE

         */

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM d eeee");
        String text = date.format(formatter);
        System.out.println(text);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(parsedDate);
        formatter = DateTimeFormatter.ofPattern("yyyy MMMM d eeee", Locale.FRENCH);
        System.out.println(date.format(formatter));
        formatter = DateTimeFormatter.ofPattern("yyyy MMMM d eeee", Locale.forLanguageTag("es-ES"));
        System.out.println(date.format(formatter));

    }
}
