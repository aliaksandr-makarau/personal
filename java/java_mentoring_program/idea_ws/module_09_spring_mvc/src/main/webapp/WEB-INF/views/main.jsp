<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Main</title>
    </head>
    <body>
        <h1>The main page of cabs application</h1>
        <h1> ${cab_name} </h1>
        <table>
            <c:forEach items="${cabs}" var="cab">
                <tr>
                    <td>${cab.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>