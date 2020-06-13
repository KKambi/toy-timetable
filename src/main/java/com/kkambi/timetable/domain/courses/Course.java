package com.kkambi.timetable.domain.courses;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String title;

    private String professor;

    private String building;

    private String room;

    private int startTime;

    private int endTime;

    private String dayOfWeek;

    @Builder
    public Course(String code, String title, String professor, String building, String room, int startTime, int endTime, String dayOfWeek) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.building = building;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }
}
