package com.kkambi.timetable.domain.memo;

import com.kkambi.timetable.domain.course.Course;
import com.kkambi.timetable.domain.registrationCourse.RegistrationCourse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RegistrationCourse registrationCourse;

    private String title;

    private String content;
}
