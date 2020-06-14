package com.kkambi.timetable.web.dto;

import com.kkambi.timetable.domain.registrationCourse.RegistrationCourse;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
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

    Set<RegistrationCourse> registrationCourses;

    @Override
    public String toString() {
        return "CourseResponseDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", professor='" + professor + '\'' +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", registrationCourses=" + registrationCourses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseResponseDto that = (CourseResponseDto) o;
        return startTime == that.startTime &&
                endTime == that.endTime &&
                Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(title, that.title) &&
                Objects.equals(professor, that.professor) &&
                Objects.equals(building, that.building) &&
                Objects.equals(room, that.room) &&
                Objects.equals(dayOfWeek, that.dayOfWeek) &&
                Objects.equals(registrationCourses, that.registrationCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, title, professor, building, room, startTime, endTime, dayOfWeek, registrationCourses);
    }
}
