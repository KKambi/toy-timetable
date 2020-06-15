//Event Delegation - 강의 목록의 개별 강의 클릭 시
(function(){
    const listLecture = document.querySelector('.list-lecture');

    listLecture.addEventListener("click", (event) => {
        const cardLecture = event.target.closest("li.card-lecture");

        console.log(cardLecture);

        const lectureInfo = {
            title: cardLecture.querySelector(".lecture-title").innerText,
            dateTime: cardLecture.querySelector(".lecture-time span").innerText,
            code: cardLecture.querySelector(".list-lecture-info li:nth-child(1)").innerText,
            professor: cardLecture.querySelector(".list-lecture-info li:nth-child(2)").innerText,
            location: cardLecture.querySelector(".list-lecture-info li:nth-child(3)").innerText,
        }

        const modalBody = document.querySelector(".modal-body");

        modalBody.querySelector(".lecture-title").innerHTML = lectureInfo.title;
        modalBody.querySelector(".lecture-time span").innerHTML = lectureInfo.dateTime;
        modalBody.querySelector(".lecture-code span").innerHTML = lectureInfo.code;
        modalBody.querySelector(".lecture-professor span").innerHTML = lectureInfo.professor;
        modalBody.querySelector(".lecture-location span").innerHTML = lectureInfo.location;
        modalBody.querySelector(".txt-description").innerHTML = lectureInfo.title;

        $('#modal-lecture-info').modal('show');
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