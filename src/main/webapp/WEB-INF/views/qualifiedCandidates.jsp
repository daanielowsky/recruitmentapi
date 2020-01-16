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
<body class="bodyBackground">
<br>
<div class="container middleDiv">
    <p style="float: left">Zalogowano jako ${user.fullname}</p>
    <button style="float: right" onclick="javascript:document.location.href='/logout'">Wyloguj</button>

    <center><h2 style="padding-top: 10px">Kandydaci</h2></center>
    <p>Tutaj trafiają wszystkie aplikacje na stanowiska do firmy.</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="paddingForTable">Kandydat</th>
            <th class="paddingForTable">Pozycja</th>
            <th class="paddingForTable">Email</th>
            <th class="paddingForTable">Numer telefonu</th>
            <th class="paddingForTable">Test techniczny</th>
            <th class="paddingForTable">Rozmowa kwalifikacyjna</th>
            <th class="paddingForTable">CV</th>
            <th class="paddingForTable">Opcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="candidate">
            <tr>
                <td class="paddingForTable">${candidate.fullname}</td>
                <td class="paddingForTable">${candidate.position}</td>
                <td class="paddingForTable">${candidate.email}</td>
                <td class="paddingForTable">${candidate.phoneNumber}</td>
                <td class="paddingForTable">${candidate.technicalTest}</td>
                <td class="paddingForTable">${candidate.passingInterview}</td>
                <td class="paddingForTable"><button class="btn btn-info" onclick="window.open('/candidate/${candidate.id}/cv', target='_blank')">CV</button> </td>
                <td class="paddingForTable"><button class="btn btn-info" onclick="window.open('/candidate/${candidate.id}/cv', target='_blank')">CV</button> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
