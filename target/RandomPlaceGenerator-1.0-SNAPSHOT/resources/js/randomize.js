$(document).ready(function () {
    $("#random-button").click(function (event) {
        event.preventDefault();

        $("#random-button").addClass("rotate");
        setTimeout(function () {
            window.location.href = "/randomize";
        }, 1000);
    })
});