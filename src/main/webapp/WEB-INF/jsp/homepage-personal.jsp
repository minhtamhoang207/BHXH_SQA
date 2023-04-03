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
    <title>Trang chủ | Cá nhân</title>
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

<%--<<<<<<< HEAD--%>
<%--<div class="container-reg2" aria-orientation="horizontal">--%>
<%--    <div style="display: flex; justify-content: center;">--%>
<%--        <a class="button-29" href="/update-info-personal">--%>
<%--            Cập nhật thông tin--%>
<%--        </a>--%>
<%--    </div>--%>
<%--    <br>--%>
<%--    <hr class="solid">--%>
<%--    <br>--%>
<%--    <div style="display: flex; justify-content: center;">--%>
<%--        <a class="button-29" href="/payment-personal">--%>
<%--            Thanh toán phí bảo hiểm--%>
<%--        </a>--%>
<%--    </div>--%>
<%--=======--%>
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

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>

    <c:if test="${errorMessage != null}">
        <div class="mess" id="message">
            <div class="mess__tt">
                <h2 class="mess__title">${errorMessage}</h2>
                <div class="mess__btn" id="btnOk">OK</div>
            </div>
        </div>
    </c:if>
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
<script>
    const mess = document.getElementById('message')
    console.log(mess)
    const btn = document.getElementById('btnOk')
    btn.onclick = () => {
        mess.style = 'display: none'
    }
</script>
</html>