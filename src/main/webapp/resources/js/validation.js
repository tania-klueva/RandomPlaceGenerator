$(document).ready(function () {
    let password = document.getElementById("password");
    let passwordConfirm = document.getElementById("password-confirm");
    let validate = Array.prototype.filter.call($(".needs-validation"), function (form) {
        form.addEventListener('submit', function (event) {
            if (password != null && passwordConfirm != null) {
                if (password.value !== passwordConfirm.value) {
                    passwordConfirm.setCustomValidity("Passwords Don't Match");
                } else {
                    passwordConfirm.setCustomValidity("");
                }
            }
            if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
}, false);
