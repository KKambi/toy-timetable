package com.kkambi.timetable.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {

    private static ModelMapper modelMapper = new ModelMapper();

    private ModelMapperUtil(){
        throw new AssertionError();
    }

    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
