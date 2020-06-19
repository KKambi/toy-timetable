package com.kkambi.timetable.domain.registrationCourse;

import com.kkambi.timetable.domain.course.Course;
import com.kkambi.timetable.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RegistrationCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    @Builder
    public RegistrationCourse(Course course, User user, int startTime, int endTime, String mon, String tue, String wed, String thu, String fri) {
        this.course = course;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
    }

    @Override
    public String toString() {
        return "RegistrationCourse{" +
                "id=" + id +
                ", course=" + course +
                ", user=" + user +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", mon='" + mon + '\'' +
                ", tue='" + tue + '\'' +
                ", wed='" + wed + '\'' +
                ", thu='" + thu + '\'' +
                ", fri='" + fri + '\'' +
                '}';
    }
}
