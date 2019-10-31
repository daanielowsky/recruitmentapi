<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<center><h2>Logowanie</h2></center>
<form:form modelAttribute="user" method="post">
    <p>Nazwa użytkownika: <form:input path="username"/></p>
    <p>Hasło: <form:password path="password"/></p>
    <p><small>Zapamiętaj mnie:<input type="checkbox" name="remember-me"/></small></p>
    <form:button>Zaloguj się</form:button>
</form:form>
</body>
</html>
