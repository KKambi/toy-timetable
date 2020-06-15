package com.kkambi.timetable.web;

import com.kkambi.timetable.domain.course.CourseRepository;
import com.kkambi.timetable.util.MapperUtil;
import com.kkambi.timetable.web.dto.CourseResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void index_return_all_courses() throws Exception {
        //given
        List<CourseResponseDto> courseResponseDtos = courseRepository.findAllByOrderByCodeAsc().stream()
                        .map(course -> MapperUtil.getModelMapper().map(course, CourseResponseDto.class))
                        .collect(Collectors.toList());

        //when, then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("courses"))
                .andExpect(model().attribute("courses", courseResponseDtos));
    }
}