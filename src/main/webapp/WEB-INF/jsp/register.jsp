<%@ page contentType="text/html; charset=UTF-8" %>
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
    <title>Đăng ký tài khoản</title>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<nav class="navbar navbar-custom nav-background">
    <div class=".navbar-custom">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Bảo hiểm xã hội trực tuyến</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
        </ul>
    </div>
</nav>

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>

<div class="container">
    <div>
        <a type="button" class="button" href="/register-personal">
            <span class="button__text">Đăng ký tài khoản cá nhân</span>
            <span class="button__icon">
			<ion-icon name="accessibility-outline"></ion-icon>
		</span>
        </a>
        <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
    </div>

    <div id="your_col"></div>

    <div>
        <a type="button" class="button" href="/register-company">
            <span class="button__text">Đăng ký tài khoản doanh nghiệp</span>
            <span class="button__icon">
			<ion-icon name="podium-outline"></ion-icon>
		</span>
        </a>
        <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
    </div>
</div>
<c:if test="${errorMessage != null}">
    <div class="mess" id="message">
        <div class="mess__tt">
            <h2 class="mess__title">${errorMessage}</h2>
            <div class="mess__btn" id="btnOk">OK</div>
        </div>
    </div>
</c:if>
</body>
<script>
    const mess = document.getElementById('message')
    console.log(mess)
    const btn = document.getElementById('btnOk')
    btn.onclick = () => {
        mess.style = 'display: none'
    }
</script>
</html>