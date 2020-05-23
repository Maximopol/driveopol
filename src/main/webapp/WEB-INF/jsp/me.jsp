<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <title>Account</title>
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="limiter">

    <div class="client">
        Welcome ${surname} ${name}!!
        Email ${email}
        Role ${role}
    </div>

    <div class="buttonCreateOrder">
        <button >
<%--        <button class="login100-form-btn">--%>
            Забронировать посещение
        </button>
    </div>

    <div class="buttonChangeOrder">
        <button >
            <%--        <button class="login100-form-btn">--%>
            Изменить детали заказа
        </button>
    </div>

    <div class="buttonDeleteOrder">
        <button >
            <%--        <button class="login100-form-btn">--%>
            Удалить заказ
        </button>
    </div>




    <div>
        <c:forEach var="entry" items="${userMap}">
            User ID: <c:out value="${entry.key}"/>
            Similarity: <c:out value="${entry.value}"/>
        </c:forEach>
    </div>


<div>


    <jsp:include page="footer.jsp" />

</body>


</html>
