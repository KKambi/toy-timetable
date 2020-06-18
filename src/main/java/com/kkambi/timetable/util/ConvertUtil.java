package com.kkambi.timetable.util;

public class ConvertUtil {

    public ConvertUtil() {
        throw new AssertionError();
    }

    public static String convertTime(int time) {
        return time + ":00";
    }

    public static String convertDay(String mon, String tue, String wed, String thu, String fri) {
        String dayOfWeek = (mon.equals("Y") ? "월" : "")
                + (tue.equals("Y") ? "화" : "")
                + (wed.equals("Y") ? "수" : "")
                + (thu.equals("Y") ? "목" : "")
                + (fri.equals("Y") ? "금" : "");

        return convertDayOfWeek(dayOfWeek);
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
