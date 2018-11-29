<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Places</h1>
    <div class="row">
        <form class="w-100 m-3 border p-3 rounded bg-light" action="/place">
            <label class="sr-only text-secondary" for="page">Name</label>
            <input type="hidden" id="page" name="page" value="1">
            <div class="form-row w-100">
                <div class="form-group col-sm-4 col-md-4">
                    <label class="text-secondary" for="search">Search by name</label>
                    <input type="text" class="form-control mb-2 mr-sm-2" id="search" name="search" value="${search}" placeholder="Search...">
                </div>
                <div class="form-group col-sm-4 col-md-3">
                    <label class="text-secondary"  for="items">Items per page</label>
                    <select class="form-control mb-2 mr-sm-2" name="items" id="items" >
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                    </select>
                </div>
                <div class="form-group col-sm-4 col-md-3">
                    <label class="text-secondary" for="sort">Sort by</label>
                    <select class="form-control mb-2 mr-sm-2" name="sort" id="sort">
                        <option>Name</option>
                        <option>Specification</option>
                        <option>City</option>
                    </select>
                </div>
                <div class="form-group col-sm-4 col-md-2 d-flex justify-content-center align-items-center">
                    <button type="submit" class="btn custom-blue-button ">Submit</button>
                </div>
            </div>
        </form>
    </div>

    <c:forEach items="${errors}" var="error">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${error}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:forEach>
    <main class="row">
        <c:if test="${isAuthorized == true}">
            <a id="redColor" class="add-new-place-button text-dark border p-3 bg-light" href="user/place/create">Add new
                place</a>
        </c:if>


        <c:forEach var="place" items="${places}">
            <div class="row w-100 border p-3 rounded m-3 bg-light">
                <div class="col-md-5 overflow-hidden">
                    <img src="/image?fileName=${place.imagePath}"
                         class="img-fluid rounded overflow-hidden" alt="">
                </div>
                <div class="col-md-7">
                    <h3>${place.name}</h3>
                    <hr>
                    <p><i>${place.specification}</i></p>
                    <p>${place.city}</p>
                    <p>${place.address}</p>
                    <a href="/place?id=${place.id}" class="btn btn-primary custom-blue-button">More</a>
                </div>
            </div>
        </c:forEach>
    </main>
    <c:if test="${numberOfPages > 1}">
        <nav aria-label="pagination">
            <ul class="pagination justify-content-center">

                <c:if test="${page != 1}">
                    <li class="page-item">
                        <a class="page-link" href="/place?items=${20}&page=${page-1}&sort=${sort}" aria-label="Previous">
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
                                                     href="/place?items=${items}&page=${i}&sort=${sort}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${page lt numberOfPages}">
                    <li class="page-item">
                        <a class="page-link" href="/place?items=${items}&page=${page+1}&sort=${sort}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </c:if>

            </ul>
        </nav>
    </c:if>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>
