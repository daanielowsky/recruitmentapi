<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${listOfAllCandidates}" var="candidate">
    <p>Kandydat: ${candidate.firstname} ${candidate.lastname}</p>
    <p>Pozycja: ${candidate.position}</p>
    <p>Wymagania finansowe: ${candidate.grossExpectation}</p>
    <p>Doświadczenie: ${candidate.experience}</p>
    <p>Kiedy jest gotów zacząć: ${candidate.whenIsReadyToStart}</p>
    <p>Kontakt:
        <br>
    -Email: ${candidate.email}<br>
    -Numer Telefonu: ${candidate.phoneNumber}</p>
    <hr>
    <br>
</c:forEach>
</body>
</html>
