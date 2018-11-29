<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Your profile</h1>
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${success}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:forEach items="${errors}" var="error">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${error}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:forEach>

    <div class="p-3 border bg-light rounded row">
        <div class="col-md-3">
            <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a class="nav-link active" id="profile-pills-tab" data-toggle="pill" href="#profile-pills"
                   role="tab" aria-controls="profile-pills" aria-selected="true"><i class="fas fa-user-ninja"></i>
                    Personal info</a>
                <a class="nav-link" id="edit-pills-tab" data-toggle="pill" href="#edit-pills" role="tab"
                   aria-controls="edit-pills" aria-selected="false"><i class="fas fa-user-edit"></i> Edit personal info
                </a>
                <a class="nav-link" id="edit-password-pills-tab" data-toggle="pill"
                   href="#edit-password-pills"
                   role="tab"
                   aria-controls="edit-password-pills" aria-selected="false"><i class="fas fa-user-shield"></i>
                    Change
                    password</a>
                <a class="nav-link" id="place-pills-tab" data-toggle="pill" href="#place-pills"
                   role="tab"
                   aria-controls="place-pills" aria-selected="false"><i class="fas fa-cookie"></i> Your places</a>
            </div>
        </div>
        <div class="col-md-9">
            <div class="tab-content" id="v-pills-tabContent">

                <div class="tab-pane show active fade p-3" id="profile-pills" role="tabpanel"
                     aria-labelledby="profile-pills-tab">
                    <div class="row">
                        <div class="col-4"><p class="">First name</p></div>
                        <div class="col-8"><p class="text-secondary">${user.firstName}</p></div>
                    </div>
                    <div class="row">
                        <div class="col-4"><p class="">Last name</p></div>
                        <div class="col-8"><p class="text-secondary">${user.lastName}</p></div>
                    </div>
                    <div class="row">
                        <div class="col-4"><p class="">City</p></div>
                        <div class="col-8"><p class="text-secondary">${user.city}</p></div>
                    </div>
                    <div class="row">
                        <div class="col-4"><p class="">Email</p></div>
                        <div class="col-8"><p class="text-secondary">${user.email}</p></div>

                    </div>
                </div>
                <div class="tab-pane fade  p-3" id="edit-pills" role="tabpanel" aria-labelledby="edit-pills-tab">
                    <form method="post" action="<c:url value="/user/page?edit=info"/>"
                          class="creation-form needs-validation" novalidate>
                        <div class="form-group row">
                            <label for="email" class="col-sm-3 col-form-label">E-mail</label>
                            <div class="col-sm-9">
                                <input type="email" name="email" class="form-control"
                                       id="email" value="${user.email}" placeholder="Enter your email" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="first-name" class="col-sm-3 col-form-label">First Name</label>
                            <div class="col-sm-9">
                                <input type="text" name="firstName" class="form-control"
                                       id="first-name" value="${user.firstName}"
                                       placeholder="Enter yout first name"
                                       required>
                                <div class="invalid-feedback">
                                    <i class="fas fa-ban"></i> Please provide a valid email.
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
                                       id="last-name" value="${user.lastName}"
                                       placeholder="Enter your last name" required>
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
                </div>
                <div class="tab-pane fade  p-3" id="edit-password-pills" role="tabpanel"
                     aria-labelledby="edit-password-pills-tab">
                    <form method="post" action="<c:url value="/user/page?edit=password"/>"
                          class="creation-form needs-validation" novalidate>
                        <div class="form-group row">
                            <label for="old-password" class="col-sm-3 col-form-label">Your current password</label>
                            <div class="col-sm-9">
                                <input type="password" name="oldPassword" class="form-control"
                                       id="old-password" value=""
                                       placeholder="Enter current password" required pattern="[a-zA-Z0-9]{6,20}">
                                <div class="invalid-feedback">
                                    <i class="fas fa-ban"></i> Please provide a valid password.
                                </div>
                                <div class="valid-feedback">
                                    <i class="far fa-check-circle"></i> Good!
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="password" class="col-sm-3 col-form-label">Your new password</label>
                            <div class="col-sm-9">
                                <input type="password" name="newPassword" class="form-control"
                                       id="password" value=""
                                       placeholder="Enter new password" required pattern="[a-zA-Z0-9]{6,20}">
                                <div class="invalid-feedback">
                                    <i class="fas fa-ban"></i> Please provide a valid password.
                                </div>
                                <div class="valid-feedback">
                                    <i class="far fa-check-circle"></i> Good!
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="password-confirm" class="col-sm-3 col-form-label">Repeat
                                password</label>
                            <div class="col-sm-9">
                                <input type="password" name="passwordConfirm" class="form-control"
                                       id="password-confirm" value=""
                                       placeholder="Enter password once again" required>
                                <div class="invalid-feedback">
                                    Password do not matches.
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
                </div>

                <div class="tab-pane fade p-3" id="place-pills" role="tabpanel"
                     aria-labelledby="place-pills-tab">
                    <c:forEach items="${userPlaceErrors}" var="userPlaceError">
                        <div class="alert alert-light alert-dismissible fade show" role="alert">
                                ${userPlaceError}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:forEach>
                    <c:forEach var="place" items="${places}">
                        <div class="row w-100 border p-3 rounded m-3 bg-light-custom">
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
                    <c:if test="${numberOfPages > 1}">
                        <nav aria-label="pagination">
                            <ul class="pagination justify-content-center">

                                <c:if test="${page != 1}">
                                    <li class="page-item">
                                        <a class="page-link" href="/user/page?items=${5}&page=${page-1}"
                                           aria-label="Previous">
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
                                                                     href="/user/page?items=${5}&page=${i}">${i}</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                                <c:if test="${page lt numberOfPages}">
                                    <li class="page-item">
                                        <a class="page-link" href="/user/page=${5}&page=${page+1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </li>
                                </c:if>

                            </ul>
                        </nav>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp"/>