<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <title>Cập nhật thông tin nhân viên</title>
</head>

<body>

<div class="container">

    <form:form action="" method="post" modelAttribute="user">

        <div class="signup">
            <div class="signup__head">
                <div>
                    <h3 class="signup__title">
                        Cập nhật thông tin người dùng
                    </h3>
                </div>
            </div>

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
                        <input path="" type="text" class="signup__input" value="${user.email}" placeholder=""
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

<%--    <c:if test="${errorMessage != null}">--%>
<%--        <div class="mess" id="message">--%>
<%--            <div class="mess__tt">--%>
<%--                <h2 class="mess__title">${errorMessage}</h2>--%>
<%--                <div class="mess__btn" id="btnOk">OK</div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </c:if>--%>
</div>
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