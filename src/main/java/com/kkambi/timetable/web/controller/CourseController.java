package com.kkambi.timetable.web.controller;

import com.kkambi.timetable.service.CourseService;
import com.kkambi.timetable.web.dto.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private static final Logger logger = LogManager.getLogger(RegistrationCourseController.class);

    private final CourseService courseService;

    @GetMapping("/course/{id}")
    public CourseResponseDto findById(@PathVariable("id") Long id) {

        logger.info("");
        logger.info("===== 강의 조회 요청 =====");
        logger.info("GET: /course/" + id);

        return courseService.findById(id);
    }
}
