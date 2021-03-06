package com.kkambi.timetable.service;

import com.kkambi.timetable.domain.course.Course;
import com.kkambi.timetable.domain.registrationCourse.RegistrationCourse;
import com.kkambi.timetable.domain.registrationCourse.RegistrationCourseRepository;
import com.kkambi.timetable.domain.user.User;
import com.kkambi.timetable.util.MapperUtil;
import com.kkambi.timetable.util.ParseUtil;
import com.kkambi.timetable.web.dto.RegistrationCourseResponseDto;
import com.kkambi.timetable.web.dto.RegistrationCourseSaveDto;
import com.kkambi.timetable.web.dto.RegistrationCourseSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegistrationCourseService {

    @PersistenceContext
    private EntityManager entityManager;

    private final RegistrationCourseRepository registrationCourseRepository;

    public RegistrationCourseSaveDto parseRegisterDto(RegistrationCourseSaveRequestDto registrationCourseSaveRequestDto) {
        return ParseUtil.parseRegisterRequestDto(registrationCourseSaveRequestDto);
    }

    @Transactional(readOnly = true)
    public List<RegistrationCourseResponseDto> findAllRegistrationCourses() {
        return registrationCourseRepository.findAllByOrderByStartTime().stream()
                .map(registrationCourse -> {
                    RegistrationCourseResponseDto registrationCourseResponseDto = MapperUtil.getModelMapper().map(registrationCourse, RegistrationCourseResponseDto.class);
                    Course course = registrationCourse.getCourse();
                    registrationCourseResponseDto.setCourseId(course.getId());
                    registrationCourseResponseDto.setCode(course.getCode());
                    registrationCourseResponseDto.setTitle(course.getTitle());
                    registrationCourseResponseDto.setProfessor(course.getProfessor());
                    registrationCourseResponseDto.setBuilding(course.getBuilding());
                    registrationCourseResponseDto.setRoom(course.getRoom());
                    return registrationCourseResponseDto;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public boolean findOverlappedRegistrationCourse(RegistrationCourseSaveDto registrationCourseSaveDto) {
        List<RegistrationCourse> registrationCourses = registrationCourseRepository.findOverlappedRegistrationCourse(
                registrationCourseSaveDto.getStartTime(),
                registrationCourseSaveDto.getEndTime(),
                registrationCourseSaveDto.getMon(),
                registrationCourseSaveDto.getTue(),
                registrationCourseSaveDto.getWed(),
                registrationCourseSaveDto.getThu(),
                registrationCourseSaveDto.getFri());

        return registrationCourses.size() > 0;
    }

    @Transactional
    public RegistrationCourse register(RegistrationCourseSaveRequestDto registrationCourseSaveRequestDto) {
        RegistrationCourseSaveDto registrationCourseSaveDto = ParseUtil.parseRegisterRequestDto(registrationCourseSaveRequestDto);

        RegistrationCourse registrationCourse = MapperUtil.getModelMapper().map(registrationCourseSaveDto, RegistrationCourse.class);
        registrationCourse.setCourse(entityManager.getReference(Course.class, registrationCourseSaveDto.getCourseId()));
        registrationCourse.setUser(entityManager.getReference(User.class, registrationCourseSaveDto.getUserId()));
        entityManager.persist(registrationCourse);

        return registrationCourseRepository.save(registrationCourse);
    }
}
