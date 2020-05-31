<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Title</title>
    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet">
    <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #f5f5f5;
        }
        .footer .container {
            width: auto;
            max-width: 680px;
            padding: 0 15px;
        }
    </style>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
    <div class="">
        <img src =
                     "https://www.kv.by/sites/default/files/user7743/logo_iba_group.jpg" width="50"
             height="50">
    </div>
    <div class="navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a
                    href="${pageContext.request.contextPath}/controller?command=login_page">Login</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a
                    href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <H2>Welcome ${username}</H2>
    <caption>Список вашей группы</caption>
    <table border="1">
        <tr>
            <th>Имя</th>
            <th>Телефон</th>
            <th>email</th>
        </tr>
        <c:forEach items="${group}" var="person">
            <tr><td>${person.name}</td>
                <td>${person.phone}</td>
                <td>${person.email}</td>
            </tr>
        </c:forEach>
    </table>
    <p><font color="red">${errorMessage}</font></p>
    <form method="POST"
          action="${pageContext.servletContext.contextPath}/controller?command=add_new_perso
n">
        Новый :
        <p> Введите имя <input name="nname" type="text" /> </p>
        <p> Введите телефон <input name="nphone" type="text" /> </p>
        <p> Введите email <input name="nemail" type="text" /> </p>
        <input class ="button-main-page" value="Добавить" type="submit" />
    </form>
</div>
<p> ${lastdate}</p>
<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>