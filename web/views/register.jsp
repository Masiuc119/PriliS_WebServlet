<%--
  Created by IntelliJ IDEA.
  User: Alex7
  Date: 16.03.2020
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${errorRegister}</font></p>
<form action="RegisterServlet" method="POST">
    <p> Регистрация нового пользователя </p>
    <p> Введите имя : <input name="newLoginName" type="text" />
    </p>
    <p> Введите пароль : <input name="newPassword" type="password" />
    </p>
    <input class ="button-main-page" type="submit" value="Зарегистрировать"/>
</form>
</body>
</html>
