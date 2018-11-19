<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="display-3 text-center font-weight-light text-blue p-5 m-after-nav">${place.name}</h1>
    <div class="py-5">
        <h2 class="text-center font-weight-light">About us</h2>
        <div class="p-5 border rounded desc-block bg-light">
            <div class="row">
                <div class="col-4"><p class="text-light">Specification</p></div>
                <div class="col-8"><p class="">${place.specification}</p></div>
            </div>
            <div class="row">
                <div class="col-4"><p class="text-light">Address</p></div>
                <div class="col-8"><p class="">${place.address}</p></div>
            </div>

            <div class="row">
                <p>${place.description}</p>
            </div>

            <div class="row place-crud-button">
                <a href="place/edit?id=${place.id}" class="text-dark">Edit</a>
                <form method="post" action="place/delete?id=${place.id}" >
                    <input type="submit" value="Delete" class="text-dark bg-light">
                </form>
            </div>
        </div>
        <h2 class="text-center font-weight-light">Photos</h2>
        <div class="gallery p-5 card-columns">
            <div class="card">
                <img class="card-img" src="image.jpeg" class="rounded img-fluid"/>
            </div>
            <div class="card">
                <img class="card-img" src="image.jpeg" class="rounded img-fluid"/>
            </div>
            <div class="card">
                <img class="card-img" src="image.jpeg" class="rounded img-fluid"/>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../WEB-INF/footer.jsp"/>