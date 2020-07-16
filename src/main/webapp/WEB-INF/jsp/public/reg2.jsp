<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/login2.css">
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="fon">
    <div class="formlogin">
        Account creation
        <form class="login100-form" method="post">

            <div class="inputkek">
                <input class="input100" type="text" name="surname" placeholder="Surname" th:field="*{surname}" />
            </div>

            <div class="inputkek">
                <input class="input100" type="text" name="name" placeholder="Name" th:th:field="*{name}" />
            </div>

            <div class="inputkek">
                <input class="input100" type="text" name="email" placeholder="Email" th:field="*{email}" />
            </div>

            <div class="inputkek">
                <input class="input100" type="password" name="password" placeholder="Password" th:field="*{password}" />
            </div>

            <div class="inputkek">
                <input class="input100" type="password" name="passwordConfirm" placeholder="Confirm the password" th:field="*{passwordConfirm}" />
            </div>

            <div>
                ${passwordError}
            </div>

            <div>
                <button class="login100-form-btn">
                    Create
                </button>
            </div>

            <div>
                <a class="txt2" href="${pageContext.request.contextPath}/newlogin">
                    Login
                </a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
