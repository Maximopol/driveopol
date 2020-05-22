<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div>


    <div>
        <c:forEach var="service" items="${services}">
            User ID: <c:out value="${service.key}"/>
            Similarity: <c:out value="${service.value}"/>
        </c:forEach>
    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>