import { renderRegistrationCourses } from "./renderRegistrationCourses.js"
import { showModalLectureInfo } from "./showModalLectureInfo.js"
import { showModalLectureTask } from "./showModalLectureTask.js"

//Initialization - 등록된 강의 목록 불러오기
(async function(){
    try {
        const res = await fetch(`${window.location.protocol}//${window.location.host}/registrationCourses`);
        const registrationCourses = await res.json();
        renderRegistrationCourses(registrationCourses);
    } catch (err) {
        console.log("등록강의 조회 오류 발생!");
        console.log(err);
    }
})();

//Event Delegation - 강의 목록의 개별 강의 클릭 시
(function(){
    const listLecture = document.querySelector('.list-lecture');

    listLecture.addEventListener("click", (event) => {
        try {
            showModalLectureInfo(event);
        } catch (err) {
            console.log("강의정보 모달 오류 발생!");
            console.log(err);
        }
    })
})();

//Event Delegation - 등록 강의 목록의 개별 강의 클릭 시
(function(){
    const timeTable = document.querySelector('.table-schedule-subject');

    timeTable.addEventListener("click", async (event) => {
        try {
            const lecture = event.target.closest("li.lecture-time");

            if (lecture === null) return;

            const id = lecture.querySelector(".lecture-id").innerText;

            const res = await fetch(`${window.location.protocol}//${window.location.host}/course/${id}`);
            const course = await res.json();

            showModalLectureTask(course);
        } catch (err) {
            console.log("등록강의정보 모달 오류 발생!");
            console.log(err);
        }
    })
})();

//과목 등록하기 버튼
(function(){
    const registerButton = document.querySelector("#modal-lecture-register");

    registerButton.addEventListener("click", async (event) => {
        const lecture = event.target.closest("#modal-lecture-info");

        const lectureInfo = {
            courseId: lecture.querySelector(".lecture-id").innerText,
            userId: document.querySelector("#user-id").innerText,
            time: lecture.querySelector(".lecture-time span").innerText,
        }

        try {
            const res = await fetch(`${window.location.protocol}//${window.location.host}/course`, {
                method: "POST",
                cache: "no-cache",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(lectureInfo),
            });

            if (res.status === 200) {
                alert("강의 등록 성공!");
            }
            else {
                alert("강의 등록 실패!");
            }

            const jsonBody = await res.json();
            console.log(jsonBody);

            window.location.reload();

        } catch (err) {
            console.log("강의 등록 오류 발생!");
            console.log(err);
        }
    })
})();


$(function () {
  $('[data-toggle="tooltip"]').tooltip();
});

$(function () {
  $('[data-toggle="popover"]').popover({
    container: 'body',
    html: true,
    placement: 'right',
    sanitize: false,
    content: function () {
    return $("#PopoverContent").html();
    }
  });
});