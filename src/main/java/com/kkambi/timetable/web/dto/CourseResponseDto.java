package com.kkambi.timetable.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CourseResponseDto {

    private Long id;

    private String code;

    private String title;

    private String professor;

    private String building;

    private String room;

    private String startTime;

    private String endTime;

    private String dayOfWeek;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseResponseDto that = (CourseResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(title, that.title) &&
                Objects.equals(professor, that.professor) &&
                Objects.equals(building, that.building) &&
                Objects.equals(room, that.room) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(dayOfWeek, that.dayOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, title, professor, building, room, startTime, endTime, dayOfWeek);
    }
}
