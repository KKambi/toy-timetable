package com.kkambi.timetable.web;

import com.kkambi.timetable.service.RegistrationCourseService;
import com.kkambi.timetable.web.dto.RegistrationCourseSaveDto;
import com.kkambi.timetable.web.dto.RegistrationCourseSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegistrationCourseController {

    private static final Logger logger = LogManager.getLogger(RegistrationCourseController.class);

    private final RegistrationCourseService registrationCourseService;

    @PostMapping("/course")
    public Long register(@RequestBody RegistrationCourseSaveRequestDto registrationCourseSaveRequestDto) throws Exception {

        //JSON Post Body
        logger.info("");
        logger.info("===== 강의 등록 요청 =====");
        logger.info("POST: /course: courseId : " + registrationCourseSaveRequestDto.getCourseId());
        logger.info("POST: /course: userId : " + registrationCourseSaveRequestDto.getUserId());
        logger.info("POST: /course: time : " + registrationCourseSaveRequestDto.getTime());
        logger.info("");

        //1. 조회용 Dto 변환
        RegistrationCourseSaveDto registrationCourseSaveDto = registrationCourseService.parseRegisterDto(registrationCourseSaveRequestDto);

        //2. 이미 시간표에 등록된 강의 중, 겹치는 강의가 있는지 조회
        boolean isOverlapped = registrationCourseService.findOverlappedRegistrationCourse(registrationCourseSaveDto);

        //3. 겹치는 강의가 있다면 Throw Exception
        if (isOverlapped) {
            throw new Exception("겹쳐요");
        }

        //4. 겹치는 강의가 없다면 Save
        return registrationCourseService.register(registrationCourseSaveRequestDto);
    }
}
