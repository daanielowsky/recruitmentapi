<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recruitment</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form:form modelAttribute="candidate" method="post" enctype="multipart/form-data" cssClass="was-validated">
<center>
    <c:if test="${param.complete != null}">
        <h1><p style="color: greenyellow">Twoje zgłoszenie zostało wysłane! Dziękujemy.</p></h1>
    </c:if>
    <h1>Dane kandydata</h1></center>
<p><form:label path="firstName">Imię*</form:label></p>
<p><form:input path="firstName"/><form:errors path="firstName"/><form:errors path="lastName"/></p>
<br>

<p><form:label path="lastName">Nazwisko*</form:label></p>
<p><form:input path="lastName"/></p>
<br>

<p><form:label path="email">E-mail*</form:label><form:errors path="email"/></p>
<p><form:input path="email"/></p>
<br>

<p><form:label path="phoneNumber">Telefon komórkowy</form:label><form:errors path="phoneNumber"/></p>
<p><form:input path="phoneNumber"/></p>
<br>

<p><form:label path="experience">Czy posiadasz doświadczenie? Jeśli jak to ile i jakie.*</form:label><form:errors
        path="experience"/></p>
<p><form:textarea path="experience"/></p>
<br>

<p><form:label path="position">Na jakie stanowisko chcesz aplikować?*</form:label><form:errors path="position"/></p>
<p><form:input path="position"/></p>
<br>

<p><form:label path="file">CV*</form:label><form:errors path="file"/></p>
<p><input type="file" name="file"></p>
<br>

<center><h1>Dodatkowe pytania</h1></center>
<br>

<p><form:label path="whenIsReadyToStart">Od kiedy jesteś gotowy by zacząć pracę?</form:label><form:errors
        path="whenIsReadyToStart"/></p>
<p><form:input path="whenIsReadyToStart"/></p>
<br>

<p><form:label path="grossExpectation">Jakie są Twoje oczekiwania finansowe (brutto)?</form:label><form:errors
        path="grossExpectation"/></p>
<p><form:input path="grossExpectation"/></p>
<br>

<center><h2>Zgoda</h2></center>
<div class="form-group form-check">
    <form:checkbox path="agreement" value="${candidate.agreement}"/> ${candidate.agreement}
</div>
    <br>
    <button type="submit" class="btn btn-primary">WYŚLIJ</button>
    </form:form>
<br>
</div>
</body>
</html>
