package cn.lujiawu.garmin2suunto.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getNowDate(){
        return localDateToString(LocalDate.now());
    }

    public static String getLast2WeekDate(){
        LocalDate localDate = LocalDate.now().minusDays(14);
        return localDateToString(localDate);
    }

    private static String localDateToString(LocalDate localDate) {
        if ( localDate == null ) {
            return "";
        }
        return  localDate.format(formatter);
    }

}
