<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recruitment</title>
</head>
<body>
<form:form modelAttribute="candidate" method="post" enctype="multipart/form-data">
    <center><h1>Dane kandydata</h1></center>
    <p>Imię*</p>
    <p><form:input path="firstName"/><form:errors path="firstName"/></p>
    <br>

    <p>Nazwisko*</p>
    <p><form:input path="lastName"/><form:errors path="lastName"/></p>
    <br>

    <p>E-mail*</p>
    <p><form:input path="email"/><form:errors path="email"/></p>
    <br>

    <p>Telefon komórkowy</p>
    <p><form:input path="phoneNumber"/><form:errors path="phoneNumber"/></p>
    <br>

    <p>Czy posiadasz doświadczenie? Jeśli jak to ile i jakie.*</p>
    <p><form:input path="experience"/><form:errors path="experience"/> </p>
    <br>

    <p>Na jakie stanowisko chcesz aplikować?*</p>
    <p><form:input path="position"/><form:errors path="position"/> </p>
    <br>

    <p>CV*</p>
    <p><input type="file" name="file"><form:errors path="file"/></p>
    <br>

    <center><h1>Dodatkowe pytania</h1></center>
    <br>

    <p>Od kiedy jesteś gotowy by zacząć pracę?</p>
    <p><form:input path="whenIsReadyToStart"/><form:errors path="whenIsReadyToStart"/></p>
    <br>

    <p>Jakie są Twoje oczekiwania finansowe (brutto)?</p>
    <p><form:input path="grossExpectation"/><form:errors path="grossExpectation"/></p>
    <br>

    <center><h2>Zgoda</h2></center>
    <p><form:checkbox path="agreement" value="true"/> ${candidate.agreement}</p>
    <br>
    <form:button>WYŚLIJ</form:button>
</form:form>
</body>
</html>
