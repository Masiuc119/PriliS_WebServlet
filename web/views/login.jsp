<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${errorMessage}</font></p>
<form
        action="${pageContext.servletContext.contextPath}/controller?command=login"
        method="POST">
    <p> Вход в систему </p>
    <p> Имя : <input name="loginName" type="text" />
    </p>
    <p> Пароль : <input name="password" type="password" />
    </p>
    <input class ="button-main-page" type="submit" value="Войти"/>
</form>
<div>
    <form
            action="${pageContext.servletContext.contextPath}/controller?command=registration_
page" method="post">
        <input class ="button-main-page" type="submit" value="Регистрация"/>
    </form>
</div>
</body>
</html>