<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workers</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/workers.css">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="limiter">
    <div class="tableService">
        <table border="1">
            <caption>Эти наши талантливые работники</caption>

            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Должность</th>
                <th>Стаж (месяц)</th>
            </tr>

            <c:forEach var="Employees" items="${employees}">
                <tr>
                    <th><c:out value="${Employees.value.me.surname}"/></th>
                    <th><c:out value="${Employees.value.me.surname}"/></th>
                    <th><c:out value="${Employees.value.position2.name}"/></th>
                    <th><c:out value="${Employees.value.experience}"/></th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<
<jsp:include page="footer.jsp"/>
</body>
</html>
