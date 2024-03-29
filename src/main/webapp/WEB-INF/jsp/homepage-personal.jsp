<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet" />
    <title>Trang chủ | Cá nhân</title>
    <link rel = "icon" href =
            "https://baohiemxahoi.gov.vn/images/favicon.ico?rev=23"
          type = "image/x-icon">
</head>

<style>
    .nav-background {
        background-image: url("https://png.pngtree.com/background/20220805/original/pngtree-vietnam-dong-son-bronze-drum-pattern-blue-background-picture-image_1915085.jpg");
        background-size: cover;

        /* Workaround for some mobile browsers */
        min-height: 100%;
    }
    .navbar-custom {
        background-color: cornflowerblue;
    }
    .navbar-custom .navbar-brand,
    .navbar-custom .navbar-text {
        color: white;
    }
    .nav.navbar-nav.navbar-right li a {
        color: white;
        margin-right: 20px;
    }
    ul.nav a:hover { color: black !important; }

</style>

<style>
    .container {
        display: flex;
        justify-content: center;
        margin-top: 200px;
    }
    #your_col {
        border-left: 2px solid white;
        margin-left: 50px;
        margin-right: 50px;
    }
</style>

<body>

<nav class="navbar navbar-custom nav-background">
    <div class=".navbar-custom">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Bảo hiểm xã hội trực tuyến</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Xin chào, ${userName}</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div>
        <a type="button" class="button" href="/update-info-personal">
            <span class="button__text">Cập nhật thông tin</span>
            <span class="button__icon">
			<ion-icon name="create-outline"></ion-icon>
		</span>
        </a>
        <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
    </div>

    <div id="your_col"></div>

    <div>
        <a type="button" class="button" href="/payment-personal">
            <span class="button__text">Thanh toán phí bảo hiểm</span>
            <span class="button__icon">
			<ion-icon name="wallet-outline"></ion-icon>
		</span>
        </a>
        <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
    </div>
</div>
</body>
<c:if test="${showToast}">
    <script>
        $(document).ready(function() {
            toastr.options.duration = 200;
            toastr.options.progressBar = true;
            toastr.error('', '${errorMessage}');
        });
    </script>
</c:if>
</html>