<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Sign in</h1>
    <div class="">
        <c:forEach items="${errors}" var="error">
            <p class="text-danger offset-sm-3">${error}</p>
        </c:forEach>
        <form method="post" action="/signin" class="creation-form needs-validation" novalidate>
            <div class="form-group row">
                <label for="email" class="col-sm-3 col-form-label">E-mail</label>
                <div class="col-sm-9">
                    <input type="email" name="email" class="form-control"
                           id="email" value="" placeholder="Enter your email" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid email.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="login-password" class="col-sm-3 col-form-label">Password</label>
                <div class="col-sm-9">
                    <input type="password" name="password" class="form-control"
                           id="login-password" value=""
                           placeholder="Enter password" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid password.
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
        <a href="/signup">Have no account yet?</a>
    </div>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>