package com.kkambi.timetable.util;

import com.kkambi.timetable.web.dto.RegistrationCourseSaveDto;
import com.kkambi.timetable.web.dto.RegistrationCourseSaveRequestDto;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtil {
    public ParseUtil() {
        throw new AssertionError();
    }

    private static Pattern timePattern = Pattern.compile("(.*)[:](.*) [-] (.*)[:]");

    private static Pattern dayPattern = Pattern.compile("[(](.*?)[)]");

    public static RegistrationCourseSaveDto parseRegisterRequestDto(RegistrationCourseSaveRequestDto registrationCourseSaveRequestDto) {
        Long courseId = registrationCourseSaveRequestDto.getCourseId();
        Long userId = registrationCourseSaveRequestDto.getUserId();
        String time = registrationCourseSaveRequestDto.getTime();

        //10:00 - 12:00 | (월), (금)
        ArrayList<String> timeArray = new ArrayList<>();
        Matcher timeMatcher = timePattern.matcher(time);

        while (timeMatcher.find()) {
            timeArray.add(timeMatcher.group(1));
            timeArray.add(timeMatcher.group(3));
        }

        //10:00 - 12:00 | (월), (금)
        ArrayList<String> dayArray = new ArrayList<>();
        Matcher dayMatcher = dayPattern.matcher(time);

        while (dayMatcher.find()) {
            dayArray.add(dayMatcher.group(1));
        }

        String mon = "N";
        String tue = "N";
        String wed = "N";
        String thu = "N";
        String fri = "N";

        for (String day : dayArray) {
            switch (day) {
                case "월":
                    mon = "Y";
                    break;
                case "화":
                    tue = "Y";
                    break;
                case "수":
                    wed = "Y";
                    break;
                case "목":
                    thu = "Y";
                    break;
                case "금":
                    fri = "Y";
                    break;
            }
        }

        return new RegistrationCourseSaveDto(
                courseId,
                userId,
                Integer.parseInt(timeArray.get(0)),
                Integer.parseInt(timeArray.get(1)),
                mon,
                tue,
                wed,
                thu,
                fri);
    }
}
