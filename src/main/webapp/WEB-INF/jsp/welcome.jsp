<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Welcome</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../others/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../css/welcome.css">
</head>

<body>
<jsp:include page="header.jsp" />
<div class="limiter">
    <div class="timework">///
        <img src="../others/images/unnamed.jpg" alt="Working hours: 9.00-20.00т" width="250" height="250"/>

    </div>
    <div class="description">
        <span style="font-size: 25px; color: black; font-family: Arial; ">

             Парикмахерская "Keklik"
        </span>
        <span style="font-size: 20px; color: black; font-family: 'Times New Roman'; ">
            предлагает широкий спектр современных услуг: стрижки, современные и классические методы окраски, уход за волосами, маникюр, педикюр и многое другое.
            Как добратся.
        </span>

    </div>
    <div class="map">
        <script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3A6f780547b841de1bebbf3a24b706c99fec8d078b56915d309370d2cded968375&amp;width=100%25&amp;height=400&amp;lang=ru_RU&amp;scroll=true"></script>

    </div>

</div>
<div class="footer2">
    <jsp:include page="footer.jsp" />
</div>

</body>
</html>
