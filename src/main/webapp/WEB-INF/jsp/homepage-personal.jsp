<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <title>Document</title>
</head>

<body>

<div class="container-reg2" aria-orientation="horizontal">
    <div style="display: flex; justify-content: center;">
        <a class="button-29" href="/update-info-personal">
            Cập nhật thông tin
        </a>
    </div>
    <br>
    <hr class="solid">
    <br>
    <div style="display: flex; justify-content: center;">
        <a class="button-29" href="/payment-personal">
            Thanh toán phí bảo hiểm
        </a>
    </div>


    <c:if test="${errorMessage != null}">
        <div class="mess" id="message">
            <div class="mess__tt">
                <h2 class="mess__title">${errorMessage}</h2>
                <div class="mess__btn" id="btnOk">OK</div>
            </div>
        </div>
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