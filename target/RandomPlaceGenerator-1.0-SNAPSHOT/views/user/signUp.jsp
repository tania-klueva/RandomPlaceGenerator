<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Sign up</h1>
    <div class="">
        <c:forEach items="${errors}" var="error">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    ${error}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:forEach>
        <form method="post" action="<c:url value="/signup"/>" class="creation-form needs-validation" novalidate>
            <div class="form-group row">
                <label for="email" class="col-sm-3 col-form-label">E-mail</label>
                <div class="col-sm-9">
                    <input type="email" name="email" class="form-control"
                           id="email" value="${user.email}" placeholder="Enter your email" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid email.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-3 col-form-label">Password</label>
                <div class="col-sm-9">
                    <input type="password" name="password" class="form-control"
                           id="password" value=""
                           placeholder="Enter password" required pattern="[a-zA-Z0-9]{6,20}">
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid password.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="password-confirm" class="col-sm-3 col-form-label">Confirm password</label>
                <div class="col-sm-9">
                    <input type="password" name="passwordConfirm" class="form-control"
                           id="password-confirm" value=""
                           placeholder="Enter password once again" required data-match="#password">
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Password do not matches.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good! 
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="first-name" class="col-sm-3 col-form-label">First Name</label>
                <div class="col-sm-9">
                    <input type="text" name="firstName" class="form-control"
                           id="first-name" value="${user.firstName}" placeholder="Enter your first name" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid name.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="last-name" class="col-sm-3 col-form-label">Last Name</label>
                <div class="col-sm-9">
                    <input type="text" name="lastName" class="form-control"
                           id="last-name" value="${user.lastName}" placeholder="Enter your last name" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid name.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="city" class="col-sm-3 col-form-label">City</label>
                <div class="col-sm-9">
                    <input type="text" name="city" class="form-control"
                           id="city" value="${user.city}" placeholder="Enter your city" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid city.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn custom-blue-button px-4 py-2 my-3">Submit</button>
                </div>
            </div>
        </form>
        <a href="/signin">Already have an account</a>
    </div>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>