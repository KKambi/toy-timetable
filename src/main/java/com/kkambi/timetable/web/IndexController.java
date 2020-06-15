package com.kkambi.timetable.web;

import com.kkambi.timetable.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final CourseService courseService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("courses", courseService.findAllCodeAsc());

        return "index";
    }
}
