<%--
  Created by IntelliJ IDEA.
  User: tank
  Date: 13.11.18
  Time: 16:48
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
<body class="bg-dark font-weight-light text-light ">
<jsp:include page="header.jsp"/>
<div class="container p-5">
    <h1 class="text-center py-5">Places</h1>
    <main class="row">
        <a class="nav-link" href="<c:url value='/place/create'/>">Add new place</a>
            <c:forEach var="place" items="${places}">
                <div class="row w-100 border p-3 rounded m-3">
                    <div class="col-md-5">
                        <%--<img src="1.jpeg" class="img-fluid rounded"  alt="">--%>
                    </div>
                    <div class="col-md-7">
                        <h4>${place.name}</h4>
                        <p>${place.description}</p>
                        <a href="<c:url value='place/${place.id}'/>" class="btn btn-outline-light">More</a>
                    </div>
                </div>
            </c:forEach>
        </main>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
