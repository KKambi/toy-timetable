package com.kkambi.timetable.util;

import com.kkambi.timetable.domain.course.Course;
import com.kkambi.timetable.web.dto.CourseResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class MapperUtil {

    private static final ModelMapper INSTANCE;

    public static ModelMapper getModelMapper() {
        return INSTANCE;
    }

    public MapperUtil() {
        throw new AssertionError();
    }

    static {
        PropertyMap<Course, CourseResponseDto> courseResponseDtoPropertyMap = new PropertyMap<Course, CourseResponseDto>() {
            @Override
            protected void configure () {
                using(ctx -> ConvertUtil.convertTime(
                        ((Course) ctx.getSource()).getStartTime()
                )).map(source, destination.getStartTime());

                using(ctx -> ConvertUtil.convertTime(
                        ((Course) ctx.getSource()).getEndTime()
                )).map(source, destination.getEndTime());

                using(ctx -> ConvertUtil.convertDay(
                        ((Course) ctx.getSource()).getMon(),
                        ((Course) ctx.getSource()).getTue(),
                        ((Course) ctx.getSource()).getWed(),
                        ((Course) ctx.getSource()).getThu(),
                        ((Course) ctx.getSource()).getFri()
                )).map(source, destination.getDayOfWeek());
            }
        };

        INSTANCE = new ModelMapper();
        INSTANCE.addMappings(courseResponseDtoPropertyMap);
    }
}
