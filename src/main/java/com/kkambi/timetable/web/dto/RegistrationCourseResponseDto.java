package com.kkambi.timetable.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCourseResponseDto {

    private Long id;

    private Long courseId;

    private String code;

    private String title;

    private String professor;

    private String building;

    private String room;

    private int startTime;

    private int endTime;

    private String mon;

    private String tue;

    private String wed;

    private String thu;

    private String fri;
}
