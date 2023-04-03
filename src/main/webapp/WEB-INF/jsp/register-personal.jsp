<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Đăng ký cá nhân</title>
</head>

<style>
    h4 {
        text-align: center;
        color: red
    }
</style>

<body>

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
            <br>
            <br>
            <br>

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
                    <div class="col-4 col-r">Họ và tên</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" name="full_name">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Số CCCD/CMND/Hộ chiếu</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="citizen_id">
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