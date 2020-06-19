function showModalLectureInfo(event) {
    const cardLecture = event.target.closest("li.card-lecture");

    const lectureInfo = {
        id: cardLecture.querySelector(".lecture-id").innerText,
        title: cardLecture.querySelector(".lecture-title").innerText,
        dateTime: cardLecture.querySelector(".lecture-time span").innerText,
        code: cardLecture.querySelector(".list-lecture-info li:nth-child(1)").innerText,
        professor: cardLecture.querySelector(".list-lecture-info li:nth-child(2)").innerText,
        location: cardLecture.querySelector(".list-lecture-info li:nth-child(3)").innerText,
    }

    const modalBody = document.querySelector("#modal-lecture-info .modal-body");

    modalBody.querySelector(".lecture-id").innerHTML = lectureInfo.id;
    modalBody.querySelector(".lecture-title").innerHTML = lectureInfo.title;
    modalBody.querySelector(".lecture-time span").innerHTML = `강의 시간 : ${lectureInfo.dateTime}`;
    modalBody.querySelector(".lecture-code span").innerHTML = lectureInfo.code;
    modalBody.querySelector(".lecture-professor span").innerHTML = lectureInfo.professor;
    modalBody.querySelector(".lecture-location span").innerHTML = lectureInfo.location;
    modalBody.querySelector(".txt-description").innerHTML = lectureInfo.title;

    $('#modal-lecture-info').modal('show');
}

export { showModalLectureInfo };