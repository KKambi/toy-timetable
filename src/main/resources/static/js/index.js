import { renderRegistrationCourses } from "./renderRegistrationCourses.js"

//등록된 강의 목록 불러오기
(async function(){
    try {
        const res = await fetch("http://localhost:5000/registrationCourses");

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
        const cardLecture = event.target.closest("li.card-lecture");

        const lectureInfo = {
            id: cardLecture.querySelector(".lecture-id").innerText,
            title: cardLecture.querySelector(".lecture-title").innerText,
            dateTime: cardLecture.querySelector(".lecture-time span").innerText,
            code: cardLecture.querySelector(".list-lecture-info li:nth-child(1)").innerText,
            professor: cardLecture.querySelector(".list-lecture-info li:nth-child(2)").innerText,
            location: cardLecture.querySelector(".list-lecture-info li:nth-child(3)").innerText,
        }

        const modalBody = document.querySelector(".modal-body");

        modalBody.querySelector(".lecture-id").innerHTML = lectureInfo.id;
        modalBody.querySelector(".lecture-title").innerHTML = lectureInfo.title;
        modalBody.querySelector(".lecture-time span").innerHTML = lectureInfo.dateTime;
        modalBody.querySelector(".lecture-code span").innerHTML = lectureInfo.code;
        modalBody.querySelector(".lecture-professor span").innerHTML = lectureInfo.professor;
        modalBody.querySelector(".lecture-location span").innerHTML = lectureInfo.location;
        modalBody.querySelector(".txt-description").innerHTML = lectureInfo.title;

        $('#modal-lecture-info').modal('show');
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
            const res = await fetch("http://localhost:5000/course", {
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

$('.lecture-time > a').click(function () {
  $('#modal-lecture-task').modal('show');
});

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