package com.kkambi.timetable.service;

import com.kkambi.timetable.domain.registrationCourse.RegistrationCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationCourseService {

    private final RegistrationCourseRepository registrationCourseRepository;

//    @Transactional
//    public Long save(RegisterCourseRequestDto registerCourseRequestDto) {
//        return registrationCourseRepository.save(registerCourseRequestDto.toEntity()).getId();
//    }
}
