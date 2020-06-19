package com.kkambi.timetable.web.controller;

import com.kkambi.timetable.service.CourseService;
import com.kkambi.timetable.service.RegistrationCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final CourseService courseService;

    private final RegistrationCourseService registrationCourseService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("courses", courseService.findAllCourses());

        return "index";
    }
}
