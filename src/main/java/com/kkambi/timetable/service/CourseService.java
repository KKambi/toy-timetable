package com.kkambi.timetable.service;

import com.kkambi.timetable.domain.course.CourseRepository;
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
    public List<CourseResponseDto> findAllCodeAsc() {
        return courseRepository.findAllByOrderByCodeAsc().stream()
                .map(CourseResponseDto::new)
                .collect(Collectors.toList());
    }
}
