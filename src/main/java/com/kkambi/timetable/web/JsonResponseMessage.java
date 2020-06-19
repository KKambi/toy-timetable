package com.kkambi.timetable.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JsonResponseMessage {

    private String status;

    private String message;

    private String errorMessage;

    private String errorCode;

    private int startTime;

    private int duration;

    private String location;

    private List<String> dayOfWeek;

    public JsonResponseMessage(String status, String message, String errorMessage, String errorCode) {
        this.status = status;
        this.message = message;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
