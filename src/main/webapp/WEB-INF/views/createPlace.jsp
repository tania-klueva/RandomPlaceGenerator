<%--
  Created by IntelliJ IDEA.
  User: tank
  Date: 14.11.18
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
    <link type="text/css" href="WEB-INF/resources/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="/place/create">
    <input type="hidden" value="${place.id}">
    <div class="form-group row">
        <label for="pName" class="col-sm-3 col-form-label">Name</label>
        <div class="col-sm-9">
            <input type="text" name="name" class="form-control"
                   id="pName" value="${place.name}" placeholder="Enter place`s name">
        </div>
    </div>
    <div class="form-group row">
        <label for="pAddress" class="col-sm-3 col-form-label">Address</label>
        <div class="col-sm-9">
            <input type="text" name="address" class="form-control"
                   id="pAddress" value="${place.address}" placeholder="Enter place`s address">
        </div>
    </div>
    <div class="form-group row">
        <label for="pSpecification" class="col-sm-3 col-form-label">Specification</label>
        <div class="col-sm-9">
            <input type="text" name="specification" class="form-control"
                   id="pSpecification" value="${place.specification}"
                   placeholder="Enter place`s specification">
        </div>
    </div>
    <div class="form-group row">
        <label for="place-create-about" class="col-sm-3 col-form-label">About</label>
        <div class="col-sm-9">
                                    <textarea name="description" class="form-control"
                                              id="place-create-about"
                                              placeholder="Enter smth about your place" rows="3">${place.description}
                                    </textarea>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-success px-4 py-2 my-3">Update</button>
        </div>
    </div>
</form>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
