<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <title>First Web Application</title>
</head>

<body>
<jsp:include page="header.jsp" />
<div>
    Welcome ${name}!!

    сначало тут описание барбешопа
    потом наши умные мастеры

    потом адрес

    и футер
    <div class="map">
        <script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3A6f780547b841de1bebbf3a24b706c99fec8d078b56915d309370d2cded968375&amp;width=100%25&amp;height=450&amp;lang=ru_RU&amp;scroll=true"></script>

    </div>

</div>


<jsp:include page="footer.jsp" />
</body>

</html>
