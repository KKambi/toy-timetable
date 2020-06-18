package com.kkambi.timetable.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCourseRequestDto {

    private Long userId;

    private Long courseId;

    private String time;

//    public RegistrationCourse toEntity() {
//    }
}
