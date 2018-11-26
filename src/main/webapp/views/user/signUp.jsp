<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Sign up</h1>
    <div class="">
        <c:forEach items="${errors}" var="error">
            <p class="text-danger offset-sm-3">${error}</p>
        </c:forEach>
        <form method="post" action="<c:url value="/signup"/>" class="creation-form">
            <div class="form-group row">
                <label for="email" class="col-sm-3 col-form-label">E-mail</label>
                <div class="col-sm-9">
                    <input type="email" name="email" class="form-control"
                           id="email" value="" placeholder="Enter your email" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-3 col-form-label">Password</label>
                <div class="col-sm-9">
                    <input type="password" name="password" class="form-control"
                           id="password" value=""
                           placeholder="Enter password" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="password-confirm" class="col-sm-3 col-form-label">Repeat password</label>
                <div class="col-sm-9">
                    <input type="password" name="passwordConfirm" class="form-control"
                           id="password-confirm" value=""
                           placeholder="Enter password once again" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="first-name" class="col-sm-3 col-form-label">First Name</label>
                <div class="col-sm-9">
                    <input type="text" name="firstName" class="form-control"
                           id="first-name" value="" placeholder="Enter yout first name" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="last-name" class="col-sm-3 col-form-label">Last Name</label>
                <div class="col-sm-9">
                    <input type="text" name="lastName" class="form-control"
                           id="last-name" value="" placeholder="Enter your last name" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="city" class="col-sm-3 col-form-label">City</label>
                <div class="col-sm-9">
                    <input type="text" name="city" class="form-control"
                           id="city" value="" placeholder="Enter your city" required>
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