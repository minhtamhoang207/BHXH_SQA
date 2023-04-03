<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <title>Đăng ký tài khoản</title>
</head>

<body>

<div class="container-reg">
    <div style="display: flex; justify-content: center;">
        <a class="button-29" href="/register-personal">Đăng ký tài khoản cá nhân</a>
    </div>
    <br>
    <hr class="solid">
    <br>
    <div style="display: flex; justify-content: center;">
        <a class="button-29" href="/register-company">Đăng ký tài khoản doanh nghiệp</a>
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