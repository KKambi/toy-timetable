package com.kkambi.timetable.domain.registrationCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationCourseRepository extends JpaRepository<RegistrationCourse, Long> {

    @Query(value = "select * from registration_course t1 " +
            "where :reg_st < t1.end_time " +
            "and :reg_et > t1.start_time " +
            "and ((t1.mon = 'Y' and :reg_mon = t1.mon) " +
            "OR (t1.tue = 'Y' and :reg_tue = t1.tue) " +
            "OR (t1.wed = 'Y' and :reg_wed = t1.wed) " +
            "OR (t1.thu = 'Y' and :reg_thu = t1.thu) " +
            "OR (t1.fri = 'Y' and :reg_fri = t1.fri))", nativeQuery = true)
    public List<RegistrationCourse> findOverlappedRegistrationCourse(@Param("reg_st") int startTime,
                                                                     @Param("reg_et") int endTime,
                                                                     @Param("reg_mon") String mon,
                                                                     @Param("reg_tue") String tue,
                                                                     @Param("reg_wed") String wed,
                                                                     @Param("reg_thu") String thu,
                                                                     @Param("reg_fri") String fri);

    public List<RegistrationCourse> findAllByOrderByStartTime();
}
