<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Places</h1>
    <main class="row">
        <a id="redColor" class="add-new-place-button text-dark border p-3 bg-light" href="/place/create">Add new
            place</a>
        <c:forEach var="place" items="${places}">
            <div class="row w-100 border p-3 rounded m-3 bg-light">
                <div class="col-md-5">
                    <img src="/image?fileName=${place.imagePath}"
                         class="img-fluid rounded" alt="">
                </div>
                <div class="col-md-7">
                    <h4>${place.name}</h4>
                    <hr>
                    <p>${place.specification}</p>
                    <p>${place.city}</p>
                    <p>${place.address}</p>
                    <a href="/place?id=${place.id}" class="btn btn-primary custom-blue-button">More</a>
                </div>
            </div>
        </c:forEach>
    </main>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>
