package com.kkambi.timetable.util;

import com.kkambi.timetable.domain.course.Course;
import com.kkambi.timetable.web.dto.CourseResponseDto;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
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
            protected void configure() {
                Converter<Integer, String> timeConverter = new AbstractConverter<Integer, String>() {
                    @Override
                    protected String convert(Integer source) {
                        return ConvertUtil.convertTime(source);
                    }
                };

                Converter<String, String> dayConverter = new AbstractConverter<String, String>() {
                    @Override
                    protected String convert(String source) {
                        return ConvertUtil.convertDayOfWeek(source);
                    }
                };

                using(timeConverter).map(source.getStartTime(), destination.getStartTime());
                using(timeConverter).map(source.getEndTime(), destination.getEndTime());
                using(dayConverter).map(source.getDayOfWeek(), destination.getDayOfWeek());
            }
        };

        INSTANCE = new ModelMapper();
        INSTANCE.addMappings(courseResponseDtoPropertyMap);
    }
}
