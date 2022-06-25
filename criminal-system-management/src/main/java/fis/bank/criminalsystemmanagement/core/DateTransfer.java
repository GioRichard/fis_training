package fis.bank.criminalsystemmanagement.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTransfer {
    public static final String DATE_FORMAT= "yyyy-MM-dd HH:mm";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static LocalDateTime stringToDate(final String date) {
        return LocalDateTime.parse(date, FORMATTER);
    }

    public static String dateToString(final LocalDateTime date){
        return date.format(FORMATTER);
    }
}
