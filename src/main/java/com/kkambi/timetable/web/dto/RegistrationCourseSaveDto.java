package com.kkambi.timetable.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCourseSaveDto {

    private Long id;

    private Long courseId;

    private Long userId;

    private int startTime;

    private int endTime;

    private String mon;

    private String tue;

    private String wed;

    private String thu;

    private String fri;

    public RegistrationCourseSaveDto(Long courseId, Long userId, int startTime, int endTime, String mon, String tue, String wed, String thu, String fri) {
        this.courseId = courseId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
    }

    @Override
    public String toString() {
        return "ParsedRegisterRequestDto{" +
                "courseId=" + courseId +
                ", userId=" + userId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", mon='" + mon + '\'' +
                ", tue='" + tue + '\'' +
                ", wed='" + wed + '\'' +
                ", thu='" + thu + '\'' +
                ", fri='" + fri + '\'' +
                '}';
    }
}
