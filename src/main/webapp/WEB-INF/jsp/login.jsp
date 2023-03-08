<html>

<head>
    <title>BHXH SQA</title>
</head>

<body style="align-self: center">
<form method="post">
    <fieldset id="userType">
        <input type="radio" name="userType" value=1>Ca nhan</input>
        <input type="radio" name="userType" value=2>Doanh nghiep</input>
    </fieldset>
    <br>
    Name : <input type="text" name="name" />

    <br><br>

    Password : <input type="password" name="password" />
    <br><br>
    <input type="submit" />
</form>
<br>
<br>
<font color="red">${errorMessage}</font>
</body>

</html>