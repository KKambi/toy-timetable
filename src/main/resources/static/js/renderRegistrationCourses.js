
function renderRegistrationCourses(registrationCourses) {

    const color = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10"];

    const timeConverter = new Map([
            [0, ""],
            [1, ""],
            [2, "two"],
            [3, "three"],
            [4, "four"],
            [5, "five"]
        ]);

    const dayContainer = new Map(
         [
             ["mon", document.querySelector("#timetable-mon")],
             ["tue", document.querySelector("#timetable-tue")],
             ["wed", document.querySelector("#timetable-wed")],
             ["thu", document.querySelector("#timetable-thu")],
             ["fri", document.querySelector("#timetable-fri")]
         ]);

    registrationCourses.forEach(registrationCourse => {
        const { id, title, building, room, startTime, endTime } = registrationCourse;

        const dayOfWeek = new Map(
            [
                ["mon", registrationCourse.mon],
                ["tue", registrationCourse.tue],
                ["wed", registrationCourse.wed],
                ["thu", registrationCourse.thu],
                ["fri", registrationCourse.fri]
            ]);

        for (const [day, value] of dayOfWeek) {
            if (value === "Y") {
                const template =
                        `<li class="lecture-time ${timeConverter.get(endTime - startTime)}-hr hr-${startTime}" data-event="lecture-${color[id % 10]}">
                             <a href="#">
                                 <div class="lecture-info">
                                     <div class="lecture-id" style="display: none;">${id}</div>
                                     <h6 class="lecture-title">${title}</h6>
                                     <h6 class="lecture-location">${building}동 ${room}</h6>
                                 </div>
                                 <div class="lecture-noti" data-toggle="tooltip" data-placement="top" title="" data-original-title="과제 설명 텍스트 과제 설명 텍스트 과제 설명 텍스트">
                                     <i class="material-icons ic-lecture-noti">assignment</i>
                                     <span class="lecture-noti-title">과제 제목 텍스트</span>
                                 </div>
                             </a>
                         </li>`;

                const container = dayContainer.get(day);
                container.insertAdjacentHTML("beforeend", template);
            }
        }
    })
}

export { renderRegistrationCourses };