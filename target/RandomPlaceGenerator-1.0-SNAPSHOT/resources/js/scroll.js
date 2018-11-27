
$(document).ready(function () {
    $(document).scroll(function () {
        if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
            $(".main-nav").removeClass("scroll");
            $(".main-nav .nav-link").css("fontSize", "1rem");
            $(".main-nav .navbar-brand").css("fontSize", "2.2rem");

        } else {
            $(".main-nav").addClass("scroll");
            $(".main-nav .nav-link").css("fontSize", "1.2rem");
            $(".main-nav .navbar-brand").css("fontSize", "3rem");
        }
    });
});