<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet" />
    <title>Đăng nhập</title>
    <link rel = "icon" href =
            "https://baohiemxahoi.gov.vn/images/favicon.ico?rev=23"
          type = "image/x-icon">
</head>

<body>
<div>
    <h2 class="signup__title2">Đăng nhập</h2>
</div>
<br>
<br>
<form class='login-form' action="" method="post">
    <div class="flex-row">
        <label class="lf--label" for="username">
            <svg x="0px" y="0px" width="12px" height="13px">
                <path fill="#B1B7C4"
                      d="M8.9,7.2C9,6.9,9,6.7,9,6.5v-4C9,1.1,7.9,0,6.5,0h-1C4.1,0,3,1.1,3,2.5v4c0,0.2,0,0.4,0.1,0.7 C1.3,7.8,0,9.5,0,11.5V13h12v-1.5C12,9.5,10.7,7.8,8.9,7.2z M4,2.5C4,1.7,4.7,1,5.5,1h1C7.3,1,8,1.7,8,2.5v4c0,0.2,0,0.4-0.1,0.6 l0.1,0L7.9,7.3C7.6,7.8,7.1,8.2,6.5,8.2h-1c-0.6,0-1.1-0.4-1.4-0.9L4.1,7.1l0.1,0C4,6.9,4,6.7,4,6.5V2.5z M11,12H1v-0.5 c0-1.6,1-2.9,2.4-3.4c0.5,0.7,1.2,1.1,2.1,1.1h1c0.8,0,1.6-0.4,2.1-1.1C10,8.5,11,9.9,11,11.5V12z"></path>
            </svg>
        </label>
        <input id="username" class='lf--input' placeholder='Tên đăng nhập' type='text' name="username">
    </div>
    <div class="flex-row">
        <label class="lf--label" for="password">
            <svg x="0px" y="0px" width="15px" height="5px">
                <g>
                    <path fill="#B1B7C4"
                          d="M6,2L6,2c0-1.1-1-2-2.1-2H2.1C1,0,0,0.9,0,2.1v0.8C0,4.1,1,5,2.1,5h1.7C5,5,6,4.1,6,2.9V3h5v1h1V3h1v2h1V3h1 V2H6z M5.1,2.9c0,0.7-0.6,1.2-1.3,1.2H2.1c-0.7,0-1.3-0.6-1.3-1.2V2.1c0-0.7,0.6-1.2,1.3-1.2h1.7c0.7,0,1.3,0.6,1.3,1.2V2.9z"></path>
                </g>
            </svg>
        </label>
        <input id="password" class='lf--input' placeholder='Mật khẩu' type='password' name="password">
    </div>
    <input class='lf--submit' type='submit' value='Đăng nhập'>
</form >
<a class='lf--forgot' href='register'>Đăng ký tài khoản</a>
<br>
<c:if test="${showToast}">
    <script>
        $(document).ready(function() {
            toastr.options.duration = 200;
            toastr.options.progressBar = true;
            toastr.error('', '${errorMessage}');
        });
    </script>
</c:if>
<br>

<%--<c:if test="${errorMessage != null}">--%>
<%--    <div class="mess" id="message">--%>
<%--        <div class="mess__tt">--%>
<%--            <h2 class="mess__title">${errorMessage}</h2>--%>
<%--            <div class="mess__btn" id="btnOk">OK</div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</c:if>--%>

</body>
<%--<script>--%>
<%--    const mess = document.getElementById('message')--%>
<%--    console.log(mess)--%>
<%--    const btn = document.getElementById('btnOk')--%>
<%--    btn.onclick = () => {--%>
<%--        mess.style = 'display: none'--%>
<%--    }--%>
<%--</script>--%>
</html>
