<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../WEB-INF/header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5 m-after-nav">Add new place</h1>
    <div class="">
        <form method="post" action="/place/edit" enctype="multipart/form-data" class="creation-form">
            <input type="hidden" name="id" value="${place.id}">
            <input type="hidden" name="imagePath" value="${place.imagePath}">
            <div class="form-group row">
                <label for="pName" class="col-sm-3 col-form-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" name="name" class="form-control"
                           id="pName" value="${place.name}" placeholder="Enter place`s name" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="pSpecification" class="col-sm-3 col-form-label">Specification</label>
                <div class="col-sm-9">
                    <input type="text" name="specification" class="form-control"
                           id="pSpecification" value="${place.specification}"
                           placeholder="Enter place`s specification" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="pCity" class="col-sm-3 col-form-label">City</label>
                <div class="col-sm-9">
                    <input type="text" name="city" class="form-control"
                           id="pCity" value="${place.city}" placeholder="Enter place`s city" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="pAddress" class="col-sm-3 col-form-label">Address</label>
                <div class="col-sm-9">
                    <input type="text" name="address" class="form-control"
                           id="pAddress" value="${place.address}" placeholder="Enter place`s address" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="place-create-about" class="col-sm-3 col-form-label">About</label>
                <div class="col-sm-9">
                    <textarea name="description" class="form-control" id="place-create-about" rows="3" placeholder="Enter smth about your place" required>${place.description}</textarea>
                </div>
            </div>
            <%--<div class="form-group row">--%>
                <%--<label for="pFile" class="col-sm-3 col-form-label">Attach photo</label>--%>
                <%--<div class="col-sm-9">--%>
                    <%--<input type="file" name="file" class="form-control"--%>
                           <%--id="pFile" value="" class="file" multiple data-show-upload="true" data-show-caption="true" required>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn custom-blue-button px-4 py-2 my-3">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="../../WEB-INF/footer.jsp"/>