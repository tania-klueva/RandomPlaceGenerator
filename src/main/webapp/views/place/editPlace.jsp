<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Add new place</h1>
    <div class="">
        <c:forEach items="${errors}" var="error">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${error}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:forEach>
        <form method="post" action="user/place/edit" enctype="multipart/form-data" class="creation-form needs-validation" novalidate>
            <input type="hidden" name="placeId" value="${place.id}">
            <div class="form-group row">
                <label for="pName" class="col-sm-3 col-form-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" name="name" class="form-control"
                           id="pName" value="${place.name}" placeholder="Enter place`s name" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid name.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="pSpecification" class="col-sm-3 col-form-label">Specification</label>
                <div class="col-sm-9">
                    <input type="text" name="specification" class="form-control"
                           id="pSpecification" value="${place.specification}"
                           placeholder="Enter place`s specification" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid specification.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="pCity" class="col-sm-3 col-form-label">City</label>
                <div class="col-sm-9">
                    <input type="text" name="city" class="form-control"
                           id="pCity" value="${place.city}" placeholder="Enter place`s city" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid city.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="pAddress" class="col-sm-3 col-form-label">Address</label>
                <div class="col-sm-9">
                    <input type="text" name="address" class="form-control"
                           id="pAddress" value="${place.address}" placeholder="Enter place`s address" required>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid address.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="place-create-about" class="col-sm-3 col-form-label">About</label>
                <div class="col-sm-9">
                    <textarea name="description" class="form-control" id="place-create-about" rows="3"
                              placeholder="Enter smth about your place" required>${place.description}</textarea>
                    <div class="invalid-feedback">
                        <i class="fas fa-ban"></i> Please provide a valid description.
                    </div>
                    <div class="valid-feedback">
                        <i class="far fa-check-circle"></i> Good!
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="pFile" class="col-sm-3 col-form-label">Current photo</label>
                <div class="col-sm-9">
                    <input type="hidden" name="imagePath" value="${place.imagePath}">
                    <img src="/image?fileName=${place.imagePath}" class="rounded img-fluid w-25"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="pFile" class="col-sm-3 col-form-label">New photo
                    <small class="text-muted"><br> Previous photo will be deleted</small>
                </label>
                <div class="col-sm-9">
                    <input type="file" name="file" class="form-control file"
                           id="pFile" value="" data-show-upload="true" data-show-caption="true"
                           accept="image/*" dataformatas="image/*">
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