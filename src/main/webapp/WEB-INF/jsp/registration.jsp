<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Sing up</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../css/loginutil.css">
    <link rel="stylesheet" type="text/css" href="../css/loginmain.css">
    <!--===============================================================================================-->
</head>

<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="../others/images/img-01.png" alt="IMG">
            </div>

<form:form method="POST" modelAttribute="userForm">
            <form class="login100-form" method="post">
					<span class="login100-form-title">
						Account creation
					</span>

                <div class="wrap-input100" >
    <input class="input100" type="text" name="surname" placeholder="Surname" th:field="*{surname}" />

<%--                    <input class="input100" type="text" name="surname" placeholder="Surname">--%>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100" >
    <input class="input100" type="text" name="name" placeholder="Name" th:field="*{name}" />
<%--                    <input class="input100" type="text" name="name" placeholder="Name">--%>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100" >
    <input class="input100" type="text" name="middleName" placeholder="Middle name" th:field="*{middleName}" />
<%--                    <input class="input100" type="text" name="middlename" placeholder="Middle name">--%>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100" >
    <input class="input100" type="text" name="email" placeholder="Email" th:field="*{Email}" />
<%--                    <input class="input100" type="text" name="email" placeholder="Email">--%>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>


                <div class="wrap-input100" >
    <input class="input100" type="password" name="password" placeholder="Password" th:field="*{password}" />
<%--                    <input class="input100" type="password" name="pass" placeholder="Password">--%>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100" >
    <input class="input100" type="password" name="confirmPassword" placeholder="Confirm the password" th:field="*{confirmPassword}" />
<%--                    <input class="input100" type="password" name="confirmpassword" placeholder="Confirm the password">--%>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Create
                    </button>
                </div>

                <div class="text-center p-t-136">
                    <a class="txt2" href="/login">
                        Login
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>

        </div>
    </div>
</div>

<!--===============================================================================================-->
<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/bootstrap/js/popper.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/tilt/tilt.jquery.min.js"></script>
<script >
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>

</body>
</html>