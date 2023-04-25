<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<title>Cá nhân | Khai báo</title>
    <link rel = "icon" href =
            "https://baohiemxahoi.gov.vn/images/favicon.ico?rev=23"
          type = "image/x-icon">
</head>

<style>
    h4 {
        text-align: center;
        color: red
    }
</style>

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
			<li onclick="history.back()">
				<a class="navbar-brand" href="#">
					<span class="glyphicon glyphicon-menu-left" style="margin-right: 10px">
					</span> Bảo hiểm xã hội trực tuyến
				</a>
			</li>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> Xin chào, ${user.fullName}</a></li>
			<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
		</ul>
	</div>
</nav>

<div class="container">

    <form:form action="" method="post" modelAttribute="user">

        <div class="signup">
            <h3 class="signup__title">
                Khai báo thông tin cá nhân
            </h3>
            <br>
            <br>
            <div class="signup__body">

                <div class="row">
                    <div class="col-4 col-r">Họ và tên</div>
                    <div class="col-8">
                        <input path="" type="text" class="signup__input" value="${user.fullName}" name="full_name">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Số CCCD/CMND/Hộ chiếu</div>
                    <div class="col-8">
                        <input path="" type="text" class="signup__input" value="${user.cccd}" placeholder=""
                               name="citizen_id">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Địa chỉ liên hệ</div>
                    <div class="col-8">
                        <input path="" type="text" class="signup__input" value="${user.address}" placeholder=""
                               name="address">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Điện thoại di động</div>
                    <div class="col-8">
                        <input path="" type="text" class="signup__input" value="${user.phone}" placeholder=""
                               name="phone_number">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Địa chỉ thư điện tử</div>
                    <div class="col-8">
                        <input path="" type="text" class="signup__input" value="${user.email}" placeholder=""
                               name="email">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Cơ quan bảo hiểm</div>
                    <div class="col-8">
                        <input path="" type="text" value="${user.coQuanBaoHiemThanhPho}" class="signup__input"
                               placeholder="" name="cqbh">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Mã số thuế</div>
                    <div class="col-8">
                        <input path="" type="text" value="${user.maSoThue}" class="signup__input" placeholder=""
                               name="tax_code"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Mức lương hiện tại</div>
                    <div class="col-8">
                        <input path="" type="number" value="${user.salary}" class="signup__input" placeholder=""
                               name="salary">
                    </div>
                </div>

            </div>
        </div>

        <div style="
    display: flex; justify-content: center;">
            <button class="btn" type="submit">
                Cập nhật thông tin
            </button>
        </div>

    </form:form>
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
</html>