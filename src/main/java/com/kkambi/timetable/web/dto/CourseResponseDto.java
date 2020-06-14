package com.kkambi.timetable.web.dto;

import com.kkambi.timetable.domain.course.Course;
import lombok.Getter;

@Getter
public class CourseResponseDto {

    private Long id;

    private String code;

    private String title;

    private String professor;

    private String building;

    private String room;

    private int startTime;

    private int endTime;

    private String dayOfWeek;

    public CourseResponseDto(Course entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.title = entity.getTitle();
        this.professor = entity.getProfessor();
        this.building = entity.getBuilding();
        this.room = entity.getRoom();
        this.startTime = entity.getStartTime();
        this.endTime = entity.getEndTime();
        this.dayOfWeek = entity.getDayOfWeek();
    }
}
