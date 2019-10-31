<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<center><h2>Rejestracja</h2></center>
<form:form modelAttribute="user" method="post">
    <p>Imię i nazwisko: <form:input path="fullname"/></p>
    <p>Nazwa Użytkownika: <form:input path="username"/></p>
    <p>Hasło<form:password path="password"/></p>
    <p>Powtórz hasło: <form:password path="confirmedPassword"/></p>
    <p><form:button>Zarejestruj</form:button></p>
</form:form>
</body>
</html>
