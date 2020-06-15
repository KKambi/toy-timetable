package com.kkambi.timetable.util;

public class ConvertUtil {

    public static String convertTime(int time) {
        return time + ":00";
    }

    public static String convertDayOfWeek(String dayOfWeek) {
        StringBuilder origin = new StringBuilder(dayOfWeek);
        StringBuilder result = new StringBuilder();
        int originLength = origin.length();

        for (int i = 0; i < originLength; i++) {
            result.append("(");
            result.append(origin.substring(i, i + 1));
            result.append(")");

            if (i == originLength - 1) {
                break;
            }

            result.append(", ");
        }

        return result.toString();
    }
}
