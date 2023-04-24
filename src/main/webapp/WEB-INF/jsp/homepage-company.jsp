<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <title>Trang chủ | Doanh Nghiệp</title>
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

    .button {
      display: flex;
      height: 38px;
      width: 270px;
      margin-left: auto;
      margin-right: 20px;
      padding: 0;
      margin-bottom: 20px;
      background: #0a76b1;
      border: none;
      outline: none;
      border-radius: 5px;
      overflow: hidden;
      font-family: "Quicksand", sans-serif;
      font-size: 16px;
      font-weight: 500;
      cursor: pointer;
    }

    .button:hover {
      background: royalblue;
    }

    .button:active {
      background: dodgerblue;
    }

    .button__text,
    .button__icon {
      display: inline-flex;
      align-items: center;
      padding: 0 24px;
      color: #fff;
      height: 100%;
    }

    .button__icon {
      font-size: 1.5em;
      background: rgba(0, 0, 0, 0.08);
    }

  </style>

  <body>
  <nav class="navbar navbar-custom nav-background">
    <div class=".navbar-custom">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Bảo hiểm xã hội trực tuyến</a>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Xin chào</a></li>
        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
      </ul>
    </div>
  </nav>
  <div>
    <a type="button" class="button" href="/add-user">
      <span class="button__text">Thêm nhân viên mới</span>
      <span class="button__icon">
          <ion-icon name="person-add-outline"></ion-icon>
		</span>
    </a>
    <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
  </div>
  <div class="content__table" style="margin-top: 10px">
      <table>
        <tr style="background-color:#0a76b1;color: #fff">
            <td style="width: 2%; min-width:35px; text-align: center">Id</td>
            <td style="width: 3%; min-width:70px; text-align: center">Tên</td>
            <td style="width: 15%; min-width:250px; text-align: center">Email</td>
            <td style="width: 10%; min-width:100px; text-align: center">Lương</td>
            <td style="width: 15%; min-width:280px; text-align: center">Thanh toán</td>
            <td style="width: 3%; min-width:70px; text-align: center">Chỉnh Sửa</td>
            <td style="width: 3%; min-width:70px; text-align: center">Xóa</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td style="width: 2%; min-width:35px; text-align: center">${user.id}</td>
                <td style="width: 3%; min-width:70px; text-align: center">${user.fullName}</td>
                <td style="width: 15%; min-width:250px; text-align: center">${user.email}</td>
                <td style="width: 10%; min-width:100px; text-align: center">${user.salary}</td>
                <td style="width: 15%; min-width:270px; text-align: center">
                    <a href="/payment-company/${user.id}">
                        <img height="15"
                             src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzYNsCQCjquUoHwtpWZ-N4r4CI-RLWAZ0ozQ&usqp=CAU"/>
                    </a>
                </td>
                <td style="width: 3%; min-width:80px; text-align: center">
                    <a href="/company-update-user/${user.id}">
                        <img src="https://img.icons8.com/external-tanah-basah-glyph-tanah-basah/15/000000/external-edit-social-media-ui-tanah-basah-glyph-tanah-basah.png"/>
                    </a>
                </td>
                <td style="width: 3%; min-width:70px; text-align: center">
                    <a href="/company-remove-user/${user.id}">
                        <img src="https://img.icons8.com/metro/15/null/trash.png"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>