
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>RentCar 🚘</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 30px;
        }
    </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">RentCar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <!-- Add Product Button -->
        <button class="btn btn-secondary my-2 my-sm-0 mr-3" data-toggle="modal" data-target="#addProductModal">Add
            Product
        </button>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <ul class="navbar-nav ml-2">
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="fas fa-user"></i> My Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<!-- Update form -->
<div class="container">
    <h2>Update Product</h2>
    <form method="post" action="/updateCar" enctype="multipart/form-data">
    <input type="hidden" id="updateCarId" name="carId" value="${car.id}">

        <div class="form-group">
            <label for="updateProductName">Product Name</label>
            <input type="text" class="form-control" id="updateProductName" name="productName"
                   value="${car.name}">
        </div>
        <div class="form-group">
            <label for="updateProductPrice">Price</label>
            <input type="text" class="form-control" id="updateProductPrice" name="productPrice"
                   value="${car.price}">
        </div>
        <div class="form-group">
            <label for="updateProductDescription">Product Description</label>
            <textarea class="form-control" id="updateProductDescription" rows="3"
                      name="productDescription">${car.description}</textarea>
        </div>
        <div class="form-group">
            <label for="updateProductImage">Product Image</label>
            <input type="file" class="form-control-file" id="updateProductImage" name="productImage">
        </div>
        <button type="submit" class="btn btn-secondary">Update Product</button>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
