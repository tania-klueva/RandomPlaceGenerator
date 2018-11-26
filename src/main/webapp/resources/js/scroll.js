
$(document).ready(function () {
    $(document).scroll(function () {
        if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
            $(".main-nav").removeClass("scroll");
            $(".nav-link").css("fontSize", "1rem");
            $(".navbar-brand").css("fontSize", "2.2rem");

        } else {
            $(".main-nav").addClass("scroll");
            $(".nav-link").css("fontSize", "1.2rem");
            $(".navbar-brand").css("fontSize", "3rem");
        }
    });
});