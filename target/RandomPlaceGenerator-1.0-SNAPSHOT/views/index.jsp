<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../WEB-INF/header.jsp"/>
<div class="random-button-section">
    <button id="random-button" class="random-button" type="submit">Randomize!</button>
</div>

<div class="random-tip border p-3">
    <p>Please click the button to randomize place where to eat</p>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/randomize.js" type="text/javascript"></script>
</body>
</html>