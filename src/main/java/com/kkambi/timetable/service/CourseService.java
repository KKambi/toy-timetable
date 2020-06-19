package com.kkambi.timetable.service;

import com.kkambi.timetable.domain.course.Course;
import com.kkambi.timetable.domain.course.CourseRepository;
import com.kkambi.timetable.util.MapperUtil;
import com.kkambi.timetable.web.dto.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public CourseResponseDto findById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return MapperUtil.getModelMapper().map(course, CourseResponseDto.class);
    }

    @Transactional(readOnly = true)
    public List<CourseResponseDto> findAllCourses() {
        return courseRepository.findAllByOrderByCodeAsc().stream()
                .map(course -> MapperUtil.getModelMapper().map(course, CourseResponseDto.class))
                .collect(Collectors.toList());
    }
}
