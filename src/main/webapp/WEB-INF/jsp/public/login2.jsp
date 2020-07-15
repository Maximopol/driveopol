<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing in</title>
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/login2.css">
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="fon">
    <div class="formlogin">
        Member Login
        <form class="login100-form" method="post">

            <div class="inputkek">
                <input class="input100" type="text" name="email" placeholder="Email">
            </div>

            <div class="inputkek">
                <input class="input100" type="password" name="pass" placeholder="Password">
            </div>

            <div>
                <button class="login100-form-btn">
                    Login
                </button>
            </div>

            <div>
                Forgot
                <a class="txt2" href="#">
                    Username / Password?
                </a>
            </div>

            <div>
                <a class="txt2" href="${pageContext.request.contextPath}/newregistration">
                    Create your Account
                </a>
            </div>

        </form>
    </div>

</div>
</body>
</html>
