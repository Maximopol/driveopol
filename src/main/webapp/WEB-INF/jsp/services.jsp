<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Price-list</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/workers.css">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="limiter">
    <div class="tableService">
        <table border="1">
            <caption>Перечень доступных услуг</caption>

            <tr>
<%--                <th>Name</th>--%>
<%--                <th>Description</th>--%>
<%--                <th>Price</th>--%>
                    <th>Название</th>
                    <th>Описание</th>
                    <th>Цена</th>
            </tr>

            <c:forEach var="service" items="${services}">
                <tr>
                    <th><c:out value="${service.value.name}"/></th>
                    <th><c:out value="${service.value.description}"/></th>
                    <th><c:out value="${service.value.price}"/></th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>