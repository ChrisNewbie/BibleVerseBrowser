<!DOCTYPE html>
<html>
<head>
    <title>Verses</title>
</head>
<body>
    <h1>Verses</h1>
    <ul>
        <c:forEach var="verse" items="${verses}">
            <li>${verse.osisID}: ${verse.text}</li>
        </c:forEach>
    </ul>
</body>
</html>
