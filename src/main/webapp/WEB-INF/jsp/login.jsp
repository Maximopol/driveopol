<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Sing in</title>
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
</head>

<body>
<font color="red">${errorMessage}</font>
<form method="post">
    Name : <input type="text" name="name" />
    Password : <input type="password" name="password" />
    <input type="submit" />
</form>
</body>

</html>