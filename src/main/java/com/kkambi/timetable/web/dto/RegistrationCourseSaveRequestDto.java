package com.kkambi.timetable.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCourseSaveRequestDto {

    private Long id;

    private Long courseId;

    private Long userId;

    private String time;
}
