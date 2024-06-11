<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>RentCar 🚘</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="./Home.css" rel="stylesheet">
    <style>
        .container-fluid {
            margin-top: 30px;
        }

        .card-img-top {
            height: 250px; /* Set the height of the card images */
            object-fit: cover; /* Ensure the images cover the entire space */
        }
    </style>
</head>
<body>
<!--navbar-Start-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">RentCar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <!-- Add Product Button -->
        <button class="btn btn-secondary my-2 my-sm-0 mr-3" data-toggle="modal" data-target="#addProductModal">Add Product</button>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>

        <ul class="navbar-nav ml-2">
         <button class="btn btn-secondary my-2 my-sm-0 mr-3" data-toggle="modal" data-target="#MyAccountModal">My Account</button>
        </ul>
    </div>
</nav>
<!--navbar-End-->

<!--Start-Card-->
<%@ page import="java.util.List" %>
<%@ page import="com.Fawry.entity.Car" %>

<%
    List<Car> cars = (List<Car>) request.getAttribute("cars");
%>

<div class="container-fluid">
    <div class="row">
        <%
            if (cars != null && !cars.isEmpty()) {
                for (Car car : cars) {
        %>
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="<%= car.getImage() %>" class="card-img-top" alt="Car Image">
                <div class="card-body">
                    <h5 class="card-title"><%= car.getName() %></h5>
                    <p class="card-text">Rent for one Day: <%= car.getPrice() %></p>
                    <p class="card-text"><%= car.getDescription() %></p>
                    <!-- Delete and Update Buttons -->
                    <div class="btn-group" role="group" aria-label="Product Actions">
                        <form action="/CarDeleteServlet" method="post">
                            <input type="hidden" name="carId" value="<%= car.getId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        <form action="/CarFindOne" method="post">
                            <input type="hidden" name="carId" value="<%= car.getId() %>">
                            <button type="submit" class="btn btn-secondary">Update</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <p>No cars found.</p>
        <%
            }
        %>
    </div>
</div>

<!--End-Card-->
<div class="modal fade" id="MyAccountModal" tabindex="-1" role="dialog" aria-labelledby="MyAccountModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addProductModalLabel">Add Name</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Add your form fields for adding a product here -->

                <form method="post" action="/MyAccount">
                    <div class="form-group">
                        <label for="productName">Product Name</label>
                        <input type="text" class="form-control" id="MyAccount" name="MyAccount">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-secondary">Save changes</button>
                    </div>
                </form>
                            </div>
                        </div>
                    </div>
                </div>


<!-- Add Product Modal -->
<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="addProductModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addProductModalLabel">Add Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Add your form fields for adding a product here -->

                <form method="post" action="/addCar" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="productName">Product Name</label>
                        <input type="text" class="form-control" id="productName" name="productName">
                    </div>
                    <div class="form-group">
                        <label for="productPrice">Price</label>
                        <input type="text" class="form-control" id="productPrice" name="productPrice">
                    </div>
                    <div class="form-group">
                        <label for="productDescription">Product Description</label>
                        <textarea class="form-control" id="productDescription" rows="3" name="productDescription"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="productImage">Product Image</label>
                        <input type="file" class="form-control-file" id="productImage" name="productImage">
                    </div>
                    <!-- Add more fields as needed -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-secondary">Save changes</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>


<!-- Bootstrap JS (optional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

