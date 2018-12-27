//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public DateUtils() {
    }

    public static String formatDateTimeForMoveWithMS(Date var0) {
        SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return var1.format(var0).substring(0, 21);
    }

    public static String formatDateTimeForMoveWithoutMS(Date var0) {
        SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return var1.format(var0);
    }

    public static String formatDateTimeForMoveWithMS(Date var0, TimeZone var1) {
        SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        var2.setTimeZone(var1);
        return var2.format(var0).substring(0, 21);
    }

    public static String setTimeZoneForMoveWithMS(String var0, TimeZone var1) throws Exception {
        SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        var2.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date var3 = var2.parse(var0);
        var2.setTimeZone(var1);
        return var2.format(var3).substring(0, 21);
    }

    public static String addSecondsToMoveWithMS(String var0, int var1) throws Exception {
        SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Date var3 = new Date(var2.parse(var0).getTime() + (long)(var1 * 1000));
        return var2.format(var3).substring(0, 21);
    }

    public static String getDateAsString(Date var0, String var1) throws Exception {
        SimpleDateFormat var2 = new SimpleDateFormat(var1);
        return var2.format(var0);
    }

    public static String formatDateTimeForMoveWithoutMS(Date var0, TimeZone var1) {
        SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        var2.setTimeZone(var1);
        return var2.format(var0);
    }

    public static Date parseString(String var0, String var1) throws Exception {
        if (null == var1 || var1.isEmpty()) {
            return null;
        } else {
            try {
                return (new SimpleDateFormat(var0)).parse(var1);
            } catch (ParseException var3) {
                throw new Exception("Date has wrong format, the pattern is " + var0 + "!");
            }
        }
    }

    public static Date setMinTime(Date var0) {
        if (var0 == null) {
            return null;
        } else {
            Calendar var1 = Calendar.getInstance();
            var1.setTime(var0);
            var1.set(11, 0);
            var1.set(12, 0);
            var1.set(13, 0);
            var1.set(14, 0);
            return var1.getTime();
        }
    }

    public static Date setMaxTime(Date var0) {
        if (var0 == null) {
            return null;
        } else {
            Calendar var1 = Calendar.getInstance();
            var1.setTime(var0);
            var1.set(11, 23);
            var1.set(12, 59);
            var1.set(13, 59);
            var1.set(14, 999);
            return var1.getTime();
        }
    }
}
