<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../media/style.css">
</head>
<body style="background-image: url('https://i.ibb.co/f8Jfsyh/hr.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;">
<br>
Witaj ${user.fullname}
<%--<br>--%>
<%--<c:forEach items="${listOfAllCandidates}" var="candidate">--%>
<%--    <p>Kandydat: ${candidate.firstname} ${candidate.lastname}</p>--%>
<%--    <p>Pozycja: ${candidate.position}</p>--%>
<%--    <p>Wymagania finansowe: ${candidate.grossExpectation}</p>--%>
<%--    <p>Doświadczenie: ${candidate.experience}</p>--%>
<%--    <p>Kiedy jest gotów zacząć: ${candidate.whenIsReadyToStart}</p>--%>
<%--    <p>Kontakt:--%>
<%--        <br>--%>
<%--        -Email: ${candidate.email}<br>--%>
<%--        -Numer Telefonu: ${candidate.phoneNumber}</p>--%>

<%--    <button onclick="javascript:document.location.href='/candidate/${candidate.id}/reject'">Odrzuć</button>--%>
<%--    <button onclick="javascript:document.location.href='/candidate/${candidate.id}/own/reject'">Odrzuć z własną--%>
<%--        wiadomością--%>
<%--    </button>--%>
<%--    <button onclick="javascript:document.location.href='/candidate/${candidate.id}/accept'">Akceptuj</button>--%>
<%--    <hr>--%>
<%--    <br>--%>
<%--</c:forEach>--%>

<div class="container" style="background: aliceblue">
    <h2>Kandydaci</h2>
    <p>Tutaj trafiają wszystkie aplikacje na stanowiska do firmy.</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="padding">Kandydat</th>
            <th class="padding">Pozycja</th>
            <th class="padding">Wymagania finansowe</th>
            <th class="padding">Doświadczenie</th>
            <th class="padding">Kiedy może rozpocząć pracę</th>
            <th class="padding">Email</th>
            <th class="padding">Numer telefonu</th>
            <th class="padding">Opcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOfAllCandidates}" var="candidate">
            <tr>
                <td class="padding">${candidate.firstname} ${candidate.lastname}</td>
                <td class="padding">${candidate.position}</td>
                <td class="padding">${candidate.grossExpectation}</td>
                <td class="padding">${candidate.experience}</td>
                <td class="padding">${candidate.whenIsReadyToStart}</td>
                <td class="padding">${candidate.email}</td>
                <td class="padding">${candidate.phoneNumber}</td>
                <td class="padding">
                    <button onclick="javascript:document.location.href='/candidate/${candidate.id}/reject'">Odrzuć
                    </button>
                    <button onclick="javascript:document.location.href='/candidate/${candidate.id}/own/reject'">Własna
                        odmowa
                    </button>
                    <button onclick="javascript:document.location.href='/candidate/${candidate.id}/accept'">Akceptuj
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
