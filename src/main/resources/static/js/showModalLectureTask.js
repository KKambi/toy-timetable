function showModalLectureTask(course) {
    const modalBody = document.querySelector("#modal-lecture-task .modal-body");

    modalBody.querySelector(".lecture-id").innerHTML = course.id;
    modalBody.querySelector(".lecture-title").innerHTML = course.title;
    modalBody.querySelector(".lecture-time span").innerHTML = `강의 시간 : ${course.startTime} - ${course.endTime} | ${course.dayOfWeek}`;
    modalBody.querySelector(".lecture-code span").innerHTML = `교과목 코드 : ${course.code}`;
    modalBody.querySelector(".lecture-professor span").innerHTML = `담당 교수 : ${course.professor}`;
    modalBody.querySelector(".lecture-location span").innerHTML = `강의실 : ${course.building}동 ${course.room}`;
    modalBody.querySelector(".txt-description").innerHTML = course.title;

    $('#modal-lecture-task').modal('show');
}

export { showModalLectureTask };