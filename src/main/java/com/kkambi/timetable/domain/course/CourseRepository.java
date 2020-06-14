package com.kkambi.timetable.domain.course;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @EntityGraph(attributePaths = "registrationCourses")
    @Query("select a from Course a")
    public List<Course> findAllByOrderByCodeAsc();
}
