<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tank
  Date: 24.11.18
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${errors}" var="error">
    <p class="text-danger offset-sm-3">${error}</p>
</c:forEach>
<h1>ERRORCHYK</h1>
</body>
</html>
