package com.kkambi.timetable.domain.course;

import com.kkambi.timetable.domain.registrationCourse.RegistrationCourse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @ColumnDefault("N")
    private String mon;

    @ColumnDefault("N")
    private String tue;

    @ColumnDefault("N")
    private String wed;

    @ColumnDefault("N")
    private String thu;

    @ColumnDefault("N")
    private String fri;

    @OneToMany(mappedBy = "course")
    Set<RegistrationCourse> registrationCourses = new LinkedHashSet<>();

    @Builder
    public Course(String code, String title, String professor, String building, String room, int startTime, int endTime, String mon, String tue, String wed, String thu, String fri) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.building = building;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
    }
}
