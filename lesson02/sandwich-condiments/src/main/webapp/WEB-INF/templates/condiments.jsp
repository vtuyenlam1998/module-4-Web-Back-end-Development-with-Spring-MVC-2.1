<%--
  Created by IntelliJ IDEA.
  User: defaultuser0
  Date: 5/9/2023
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h3>Condiments choosen</h3>
<c:forEach var="condiments" items="${condiment}">
    <p>${condiments}</p>
</c:forEach>
</body>
</html>
