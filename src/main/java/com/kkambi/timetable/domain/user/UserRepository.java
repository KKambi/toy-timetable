package com.kkambi.timetable.domain.user;

import com.kkambi.timetable.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
