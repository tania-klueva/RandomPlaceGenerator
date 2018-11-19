<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Sign in</h1>
    <div class="">
        <form method="post" action="j_security_check" enctype="multipart/form-data" class="creation-form">
            <div class="form-group row">
                <label for="email" class="col-sm-3 col-form-label">E-mail</label>
                <div class="col-sm-9">
                    <input type="email" name="j_username" class="form-control"
                           id="email" value="" placeholder="Enter your email" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-3 col-form-label">Password</label>
                <div class="col-sm-9">
                    <input type="password" name="j_password" class="form-control"
                           id="password" value=""
                           placeholder="Enter password" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn custom-blue-button px-4 py-2 my-3">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>