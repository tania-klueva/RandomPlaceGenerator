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
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Eater</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Places</a>
            </li>
        </ul>
    </div>
</nav>

<div class=" container p-5">
    <h1 class="display-3 text-center font-weight-light text-light p-5">Name</h1>
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
                    <div class="col-8"><p class="text-light">Tratatata tatata tata</p></div>
                </div>
                <div class="row">
                    <div class="col-4"><p class="text-light">City</p></div>
                    <div class="col-8"><p class="text-light">Lviv</p></div>
                </div>
                <div class="row">
                    <div class="col-4"><p class="text-light">Address</p></div>
                    <div class="col-8"><p class="text-light">Vrum vrum</p></div>
                </div>
                <div class="row">
                    <div class="col-4"><p class="text-light">Specification</p></div>
                    <div class="col-8"><p class="text-slight">Tratatata tatata tata</p></div>
                </div>

                <p class="row text-light font-weight-light">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    Alias
                    delectus deleniti et neque. Animi cumque debitis delectus, enim eum exercitationem explicabo harum
                    iusto laboriosam laudantium maxime minima minus necessitatibus nesciunt, nihil omnis optio placeat
                    provident quasi quidem repellendus repudiandae sequi unde. Alias commodi culpa dolore dolorem enim
                    facere facilis illo ipsum magni, minima, officia perferendis, perspiciatis qui quia reiciendis
                    repellat saepe tempore totam vero voluptates! Ad at cum, distinctio dolores eaque et eveniet
                    excepturi illum ipsa itaque libero magni minima modi molestiae, officiis omnis, perspiciatis porro
                    quia quis quod quos ratione recusandae rem sit suscipit temporibus tenetur ut velit vitae.</p>
                <div class="row">
                    <a href="" class="">Edit</a>
                    <a href="">Delete</a>
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
