<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
    <link rel="icon" href="/resources/cookie.png">
    <title>Just eat it!</title>
</head>
<body id="start" class="bg-light-custom font-weight-light text-dark ">
<nav class="main-nav scroll bg-dark navbar fixed-top navbar-expand-lg navbar-dark px-3 py-1" id="navbar">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" id="navbar-brand" href="/"><span class="text-blue">E</span>ater</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mx-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link mx-5" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-5" href="/place">Places</a>
            </li>
        </ul>
        <div class="dropdown ml-auto">
            <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-alt"></i>
            </button>
            <div class="dropdown-menu">
                <c:choose>
                    <c:when test="${isAuthorized == true}">
                        <a class="dropdown-item" href="/user/page">Profile</a>
                        <a class="dropdown-item" href="/logout">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a class="dropdown-item" href="/signin">Sign in</a>
                        <a class="dropdown-item" href="/signup">Sign up</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</nav>