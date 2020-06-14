package com.kkambi.timetable.util;

import org.modelmapper.ModelMapper;

public class MapperUtil {

    private static final ModelMapper INSTANCE = new ModelMapper();

    public MapperUtil() {
        throw new AssertionError();
    }

    public static ModelMapper getModelMapper() {
        return INSTANCE;
    }
}
