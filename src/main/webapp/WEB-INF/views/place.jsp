<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tank
  Date: 13.11.18
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="bg-dark">
<jsp:include page="header.jsp"/>
<div class=" container p-5">
    <h1 class="display-3 text-center font-weight-light text-light p-5">${place.name}</h1>
    <div class="row gallery overflow-hidden p-3">
        <div id="carousel1" class="carousel slide  w-100" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="row">
                        <div class="col-md-6"><img class="rounded d-block img-fluid h-300"
                                                   src="blur-breakfast-chef-262978.jpg" alt="First slide"></div>
                        <div class="col-md-6"><img class="rounded d-block img-fluid h-300"
                                                   src="beverages-brunch-cocktail-5317.jpg" alt="Second slide"></div>
                    </div>

                </div>
                <div class="carousel-item">
                    <div class="row">
                        <div class="col-md-6"><img class="rounded d-block img-fluid h-300"
                                                   src="cafe-chairs-menu-6267.jpg" alt="Third slide"></div>
                        <div class="col-md-6"><img class="rounded d-block img-fluid h-300"
                                                   src="beverages-brunch-cocktail-5317.jpg" alt="Second slide"></div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row">
                        <div class="col-md-6"><img class="rounded d-block img-fluid h-300"
                                                   src="cafe-chairs-menu-6267.jpg" alt="Third slide"></div>
                        <div class="col-md-6"><img class="rounded d-block img-fluid h-300"
                                                   src="architecture-auditorium-blue-382297.jpg" alt="Second slide">
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carousel1" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel1" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="row overflow-hidden py-5">
        <div>
            <h2 class="text-center font-weight-light text-light">About us</h2>
            <div class="p-3 border rounded">
                <div class="row">
                    <div class="col-4"><p class="text-light">Specification</p></div>
                    <div class="col-8"><p class="text-light">${place.specification}</p></div>
                </div>
                <div class="row">
                    <div class="col-4"><p class="text-light">Address</p></div>
                    <div class="col-8"><p class="text-light">${place.address}</p></div>
                </div>

                <p class="row text-light font-weight-light">${place.description}</p>
                <div class="row">
                    <a href=""<c:url value='place/edit?id=${place.id}'/>"" class="">Edit</a>
                    <form method="post" action="<c:url value='place/delete?id=${place.id}'/>">
                        <input type="submit" value="Delete">
                    </form>
                </div>


            </div>
        </div>
    </div>

</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
