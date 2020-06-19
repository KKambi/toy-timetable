package com.kkambi.timetable.web.controller;

import com.kkambi.timetable.domain.registrationCourse.RegistrationCourse;
import com.kkambi.timetable.service.RegistrationCourseService;
import com.kkambi.timetable.web.JsonResponseMessage;
import com.kkambi.timetable.web.dto.RegistrationCourseResponseDto;
import com.kkambi.timetable.web.dto.RegistrationCourseSaveDto;
import com.kkambi.timetable.web.dto.RegistrationCourseSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RegistrationCourseController {

    private static final Logger logger = LogManager.getLogger(RegistrationCourseController.class);

    private final RegistrationCourseService registrationCourseService;

    @GetMapping("/registrationCourses")
    public List<RegistrationCourseResponseDto> getAllRegistrationCourses() {
        return registrationCourseService.findAllRegistrationCourses();
    }

    @PostMapping("/course")
    public ResponseEntity<JsonResponseMessage> register(@RequestBody RegistrationCourseSaveRequestDto registrationCourseSaveRequestDto) throws Exception {

        logger.info("");
        logger.info("===== 강의 등록 요청 =====");
        logger.info("POST: /course: courseId : " + registrationCourseSaveRequestDto.getCourseId());
        logger.info("POST: /course: userId : " + registrationCourseSaveRequestDto.getUserId());
        logger.info("POST: /course: time : " + registrationCourseSaveRequestDto.getTime());

        //1. 조회용 Dto 변환
        RegistrationCourseSaveDto registrationCourseSaveDto = registrationCourseService.parseRegisterDto(registrationCourseSaveRequestDto);

        //2. 이미 시간표에 등록된 강의 중, 겹치는 강의가 있는지 조회
        boolean isOverlapped = registrationCourseService.findOverlappedRegistrationCourse(registrationCourseSaveDto);

        //3. 겹치는 강의가 있다면 Throw Exception
        if (isOverlapped) {
            logger.info("===== 강의 등록 실패 : 시간 중복 =====");
            throw new Exception("겹쳐요");
        }

        //4. 겹치는 강의가 없다면 Save
        RegistrationCourse registrationCourse = registrationCourseService.register(registrationCourseSaveRequestDto);
        JsonResponseMessage message = new JsonResponseMessage("Success", "강의 등록 성공", "", "");

        message.setStartTime(registrationCourse.getStartTime());
        message.setDuration(registrationCourse.getEndTime() - registrationCourse.getStartTime());

        List<String> dayOfWeek = new ArrayList<>();
        dayOfWeek.add(registrationCourse.getMon());
        dayOfWeek.add(registrationCourse.getTue());
        dayOfWeek.add(registrationCourse.getWed());
        dayOfWeek.add(registrationCourse.getThu());
        dayOfWeek.add(registrationCourse.getFri());
        message.setDayOfWeek(dayOfWeek);

        return new ResponseEntity<JsonResponseMessage>(message, HttpStatus.OK);
    }
}
