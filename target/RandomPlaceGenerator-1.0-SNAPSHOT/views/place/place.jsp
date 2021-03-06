<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="display-3 text-center font-weight-light text-blue p-5  m-after-nav">${place.name}</h1>
    <div class="py-5">
        <h2 class="text-center font-weight-light">About us</h2>
        <div class="p-5 border rounded desc-block bg-light">
            <div class="row">
                <div class="col-lg-6 d-flex flex-column justify-content-center align-items-stretch">
                    <div class="row">
                        <div class="col-4"><p class="">Specification</p></div>
                        <div class="col-8"><p class="text-secondary">${place.specification}</p></div>
                    </div>
                    <div class="row">
                        <div class="col-4"><p class="">City</p></div>
                        <div class="col-8"><p class="text-secondary">${place.city}</p></div>
                    </div>
                    <div class="row">
                        <div class="col-4"><p class="">Address</p></div>
                        <div class="col-8"><p class="text-secondary">${place.address}</p></div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <img src="/image?fileName=${place.imagePath}" class="rounded img-fluid"/>
                </div>
                <div class="row p-5">
                    <p class="text-secondary description">${place.description}</p>
                </div>

            </div>

            <c:if test="${canEdit == true}">
                <div class="row place-crud-button">
                    <a href="user/place/edit?id=${place.id}" class="text-dark">Edit</a>
                    <form method="post" action="user/place/delete?id=${place.id}">
                        <input type="submit" value="Delete" class="text-dark bg-light">
                    </form>
                </div>
            </c:if>
        </div>
    </div>
</div>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>