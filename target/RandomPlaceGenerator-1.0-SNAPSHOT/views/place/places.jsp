<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Places</h1>
    <main class="row">
        <c:if test="${isAuthorized == true}">
            <a id="redColor" class="add-new-place-button text-dark border p-3 bg-light" href="user/place/create">Add new
                place</a>
        </c:if>

        <c:forEach items="${errors}" var="error">
            <p class="text-danger mx-auto">${error}</p>
        </c:forEach>
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
    <nav aria-label="pagination">
        <ul class="pagination justify-content-center">
            <c:if test="${page != 1}">
                <li class="page-item">
                    <a class="page-link" href="/place?items=${20}&page=${page-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${numberOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link"
                                                 href="/place?items=${20}&page=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${page lt numberOfPages}">
                <li class="page-item">
                    <a class="page-link" href="/place?items=${20}&page=${page+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>
