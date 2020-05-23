<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Price-list</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/services.css">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="limiter">
    Парикмахерские услуги
    <div class="tableService">
        <c:forEach var="service" items="${services}">
            Name: <c:out value="${service.value.name}"/>
            Description: <c:out value="${service.value.description}"/>
            Price: <c:out value="${service.value.price}"/>
        </c:forEach>
    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>