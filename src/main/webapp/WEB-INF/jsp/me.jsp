<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Account</title>
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/me.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="limiter">

    <div class="client">
        Привет,${surname} ${name}!!<br/>
        Ваша почта:${email}<br/>
        Вы зашли как пользователь.<br/>
        Теперь можете заказывать услуги :)
    </div>

    <div class="menu">
        <form>
            <input type="button" value="Забронировать посещение" onClick='location.href="#CreateOrder"'>
        </form>

        <form>
            <input type="button" value="Изменить детали заказа" onClick='location.href="#ChangeOrder"'>
        </form>

        <form>
            <input type="button" value="Удалить заказ" onClick='location.href="#deleteOrder"'>
        </form>

        <form>
            <input type="button" value="Оставить отзыв" onClick='location.href="#"'>
        </form>
    </div>


    <div class="tableService">
        <table border="1">
            <caption>Все ваши заказанные услуги</caption>
            <tr>
                <th>ID</th>
                <th>Услуга</th>
                <th>Мастер</th>
                <th>Статус</th>
                <th>Дата заказа</th>
                <th>Дата выполнения</th>
            </tr>
            <c:forEach var="orderS" items="${orders}">
                <tr>
                    <th><c:out value="${orderS.value.id}"/></th>
                    <th><c:out value="${orderS.value.hairdressingServices.name}"/></th>
                    <th><c:out value="${orderS.value.employees.me.surname}"/>
                        <c:out value="${orderS.value.employees.me.name}"/></th>
                    <th><c:out value="${orderS.value.orderStatus.description}"/></th>
                    <th><c:out value="${orderS.value.dataCreated}"/></th>
                    <th><c:out value="${orderS.value.dataCompletion}"/></th>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="CreateOrder" class="modalDialog">
        <div>
            <a href="${pageContext.request.contextPath}/account" title="Закрыть" class="close">X</a>
            <h3>Создание заказа</h3>
            <form class="menu" method="post" modelAttribute="Order">
                Выберите дату: <input type="date" name="calendar">
                <br>
                Выбор услуг
                <select name="services">
                    <c:forEach var="service" items="${services}">
                        <option>
                            <c:out value="${service.value.name}"/>

                        </option>
                    </c:forEach>
                </select>
                <br>
                Выбор работника
                <select name="workers">
                    <c:forEach var="worker" items="${workers}">
                        <option>
                            <c:out value="${worker.value.me.surname}"/>
                            <c:out value="${worker.value.me.name}"/>

                        </option>
                    </c:forEach>
                </select>

                <div>
                    ${passwordError}
                </div>

                <div class="buttonCreateOrder">
                    <button name="createOrder">
                        Забронировать посещение
                    </button>
                </div>
            </form>
        </div>
    </div>

    <%--    --%>
    <div id="ChangeOrder" class="modalDialog">
        <div>
            <a href="${pageContext.request.contextPath}/account" title="Закрыть" class="close">X</a>
            <h3>Изменение заказа</h3>
            <form class="menu" method="post" modelAttribute="Order">
                Выберите ID заказ, которого хотите изменить:
                <select name="ordersForС">
                    <c:forEach var="orderS2" items="${orders2}">
                        <option>
                            <c:out value="${orderS2.value.id}"/>
                        </option>
                    </c:forEach>

                </select>
                Новая дата: <input type="date" name="calendarNew">
                <br>
                Выбор услуг
                <select name="servicesNew">
                    <c:forEach var="service" items="${services}">
                        <option>
                            <c:out value="${service.value.name}"/>

                        </option>
                    </c:forEach>
                </select>
                <br>
                Новый работник
                <select name="workersNew">
                    <c:forEach var="worker" items="${workers}">
                        <option>
                            <c:out value="${worker.value.me.surname}"/>
                            <c:out value="${worker.value.me.name}"/>

                        </option>
                    </c:forEach>
                </select>


                <div class="buttonChangeOrder">
                    <button name="changeOrder">
                        Изменить заказ
                    </button>
                </div>
            </form>
        </div>
    </div>

    <%----%>
    <div id="deleteOrder" class="modalDialog">
        <div>
            <a href="${pageContext.request.contextPath}/account" title="Закрыть" class="close">X</a>
            <h3>Отмена заказа</h3>
            <form class="menu" method="post" modelAttribute="Order">
                Выберите ID заказ, которого хотите отменить:

                <select name="ordersForDel">
                    <c:forEach var="orderS2" items="${orders2}">
                        <option>
                            <c:out value="${orderS2.value.id}"/>
                        </option>
                    </c:forEach>

                </select>
                <div class="buttonDeleteOrder">
                    <button name="deleteOrder">
                        Отменить
                    </button>
                </div>
            </form>
        </div>
    </div>
    <%----%>


    <div>


        <jsp:include page="footer.jsp"/>
</body>
</html>