<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet" />
    <title>Document</title>
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

<body>

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

<div class="container">
    <form action="" method="post">

        <div class="signup">
            <div class="signup__head">
                <div>
                    <h3 class="signup__title">
                        ĐĂNG KÝ
                    </h3>
                    <p class="signup__title2">Đăng ký sử dụng, điều chỉnh thông tin và ngừng sử dụng phương thức giao
                        dịch điện tử trong lĩnh vực bảo hiểm xã hội</p>
                </div>
            </div>

            <div class="signup__body">

                <div class="row">
                    <div class="col-4 col-r">Tên đăng nhập</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" name="username">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Mật khẩu</div>
                    <div class="col-8">
                        <input type="password" class="signup__input" name="password">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Nhập lại mật khẩu</div>
                    <div class="col-8">
                        <input type="password" class="signup__input" name="confirm_password">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Tên công ty</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" name="company_name">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Địa chỉ liên hệ</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="address">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Điện thoại di động</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="phone_number">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Địa chỉ thư điện tử</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="email">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Người đại diện</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="representative">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Mã số thuế</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="tax_code">
                    </div>
                </div>

            </div>
        </div>

        <div style="
    display: flex; justify-content: center;">
            <button class="btn" type="submit">
                Đăng ký
            </button>
        </div>

    </form>

    <c:if test="${errorMessage != null}">
        <div class="mess" id="message">
            <div class="mess__tt">
                <h2 class="mess__title">${errorMessage}</h2>
                <div class="mess__btn" id="btnOk">OK</div>
            </div>
        </div>
    </c:if>
    <c:if test="${showToast}">
        <script>
            $(document).ready(function() {
                toastr.options.duration = 200;
                toastr.options.progressBar = true;
                toastr.error('', '${errorMessage}');
            });
        </script>
    </c:if>
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