package com.kkambi.timetable.util;

import com.kkambi.timetable.domain.course.Course;
import com.kkambi.timetable.web.dto.CourseResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperUtilTest {

    @Test
    public void model_mapper_with_course() {
        //given
        ModelMapper modelMapper = MapperUtil.getModelMapper();

        Course course = Course.builder()
                            .code("ABC")
                            .title("영어")
                            .professor("김한비")
                            .building("A")
                            .room("304")
                            .startTime(10)
                            .endTime(13)
                            .mon("Y")
                            .tue("N")
                            .wed("N")
                            .thu("N")
                            .fri("Y")
                            .build();

        //when
        CourseResponseDto courseResponseDto = modelMapper.map(course, CourseResponseDto.class);

        //then
        assertThat(courseResponseDto.getCode(), is(equalTo(course.getCode())));
        assertThat(courseResponseDto.getTitle(), is(equalTo(course.getTitle())));
        assertThat(courseResponseDto.getDayOfWeek(), is(equalTo("(월), (금)")));
    }
}