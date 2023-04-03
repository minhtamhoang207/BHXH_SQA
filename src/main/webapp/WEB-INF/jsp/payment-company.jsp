<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/company-payment.css">
    <title>Document</title>
</head>

<style>
    h4 {
        text-align: center;
        color: blue
    }

    h5 {
        text-align: center;
        color: red
    }
</style>

<form:form method="post" modelAttribute="user">

    <div class="container">
        <div class="card">
            <div class="payment-details">
                <h3>Thanh toán bảo hiểm trực tuyến</h3>
                <br>
                <p>Vui lòng điền đầy đủ thông tin thanh toán</p>
            </div>
            <div class="input-text">
                <input type="text" placeholder="" value="${user.fullName} Thanh toán bảo hiểm trực tuyến"
                       name="content">
                <span>Nội dung chuyển khoản</span>
            </div>

            <div class="billing">
                <span>Ngân hàng</span>
                <select name="bank_name">
                    <option>VPBank (Ngân hàng TMCP Việt Nam Thịnh Vượng)</option>
                    <option>Agribank (ngân hàng Nông nghiệp và Phát triển Nông thôn Việt Nam)</option>
                    <option>BIDV (Ngân hàng TMCP Đầu tư và Phát triển Việt Nam)</option>
                    <option>TPBank (Ngân hàng Thương mại Cổ phần Tiên Phong)</option>
                    <option>MSB (Ngân hàng Thương mại Cổ phần Hàng Hải Việt Nam)</option>
                </select>
            </div>
            <div class="input-text">
                <input type="text" placeholder="" value="${transaction_code}" name="transaction_code">
                <span>Mã giao dịch</span>
            </div>
            <div class="input-text">
                <input type="text" placeholder="" value="${payment_date}" name="payment_date">
                <span>Ngày thanh toán</span>
            </div>
            <div class="input-text">
                <input type="text" placeholder="" value="${payment_amount}" name="payment_amount">
                <span>Giá trị thanh toán</span>
            </div>
            <br>
            <a href="homepage-company"><h4>${success_message}</h4></a>
            <div class="pay">
                <button type="submit" }>Thanh toán</button>
            </div>

        </div>

    </div>

</form:form>
<c:if test="${errorMessage != null}">
    <div class="mess" id="message">
        <div class="mess__tt">
            <h2 class="mess__title">${errorMessage}</h2>
            <div class="mess__btn" id="btnOk">OK</div>
        </div>
    </div>
</c:if>
<script>
    const mess = document.getElementById('message')
    console.log(mess)
    const btn = document.getElementById('btnOk')
    btn.onclick = () => {
        mess.style = 'display: none'
    }
</script>
</html>