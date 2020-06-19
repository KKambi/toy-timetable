package com.kkambi.timetable.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCourseResponseDto {

    private Long id;

    //별도맵핑
    private String code;

    //별도맵핑
    private String title;

    //별도맵핑
    private String professor;

    //별도맵핑
    private String building;

    //별도맵핑
    private String room;

    private int startTime;

    private int endTime;

    private String mon;

    private String tue;

    private String wed;

    private String thu;

    private String fri;
}
