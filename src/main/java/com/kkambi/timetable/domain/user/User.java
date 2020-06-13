package com.kkambi.timetable.domain.user;

import com.kkambi.timetable.domain.registrationCourse.RegistrationCourse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    List<RegistrationCourse> registrationCourses = new ArrayList<>();

    @Builder
    public User(List<RegistrationCourse> registrationCourses) {
        this.registrationCourses = registrationCourses;
    }
}
