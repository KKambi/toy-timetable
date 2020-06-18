package com.kkambi.timetable.web;

import com.kkambi.timetable.service.RegistrationCourseService;
import com.kkambi.timetable.web.dto.RegisterCourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegistrationCourseController {

    private final RegistrationCourseService registrationCourseService;

    @PostMapping("/course")
    public Long registerCourse(@RequestBody RegisterCourseRequestDto registerCourseRequestDto) {

        //        return registrationCourseService.save(registerCourseRequestDto);
    }
}
