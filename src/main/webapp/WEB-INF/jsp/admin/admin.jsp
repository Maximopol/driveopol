<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/admin.css">
</head>
<body>
<jsp:include page="../header.jsp"/>


<div class="limiter">
    <div class="me">
        Привет,${surname} ${name}!!<br/>
        Ваша почта:${email}<br/>
        Вы зашли как админ.<br/>
    </div>

    <div class="menu">
        <%--        <form>--%>
        <%--            <input type="button" value="Принять заказ" onClick='location.href="#takeActualOrder"'>--%>
        <%--        </form>--%>

        <%--        <form>--%>
        <%--            <input type="button" value="Изменить детали заказа" onClick='location.href="#ChangeOrder"'>--%>
        <%--        </form>--%>
    </div>
    <div class="tableService">
        <table border="1">
            <caption>Все ваши услуги</caption>
            <tr>
                <th>ID</th>
                <th>Услуга</th>
                <th>Клиент</th>
                <th>Мастер</th>
                <th>Статус</th>
                <th>Дата заказа</th>
                <th>Дата выполнения</th>
            </tr>
            <c:forEach var="orderS" items="${orders}">
                <tr>
                    <th><c:out value="${orderS.value.id}"/></th>
                    <th><c:out value="${orderS.value.hairdressingServices.name}"/></th>
                    <th><c:out value="${orderS.value.clientP.surname}"/>
                        <c:out value="${orderS.value.clientP.name}"/></th>
                    <th><c:out value="${orderS.value.employees.me.surname}"/>
                        <c:out value="${orderS.value.employees.me.name}"/></th>
                    <th><c:out value="${orderS.value.orderStatus.description}"/></th>
                    <th><c:out value="${orderS.value.dataCreated}"/></th>
                    <th><c:out value="${orderS.value.dataCompletion}"/></th>
                </tr>
            </c:forEach>
        </table>
    </div>
    <%--    --%>
    <%--    <div id="takeActualOrder" class="modalDialog">--%>
    <%--        <div>--%>
    <%--            <a href="${pageContext.request.contextPath}/master" title="Закрыть" class="close">X</a>--%>
    <%--            <h3>Получение заказа</h3>--%>
    <%--            <form class="menu" method="post" modelAttribute="Order">--%>

    <%--                Выбор заказа--%>
    <%--                <select name="servicesfF">--%>
    <%--                    <c:forEach var="service" items="${ordersNew}">--%>
    <%--                        <option>--%>
    <%--                            <c:out value="${service.value.id}"/>--%>
    <%--                        </option>--%>
    <%--                    </c:forEach>--%>
    <%--                </select>--%>

    <%--                <div class="buttonTakeOrder">--%>
    <%--                    <button name="takeOrder">--%>
    <%--                        Принять заказ--%>
    <%--                    </button>--%>
    <%--                </div>--%>
    <%--                <div class="buttonCancelOrder">--%>
    <%--                    <button name="cancelOrder">--%>
    <%--                        Отклонить заказ--%>
    <%--                    </button>--%>
    <%--                </div>--%>
    <%--            </form>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--    --%>
    <%--    <div id="CreateOrder" class="modalDialog">--%>


    <%--    </div>--%>
    <%--&lt;%&ndash;    &ndash;%&gt;--%>
    <%--    <div id="CreateOrder" class="modalDialog">--%>


    <%--    </div>--%>
</div>

<jsp:include page="../footer.jsp"/>
</body>
</html>
