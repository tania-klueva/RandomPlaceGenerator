<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../WEB-INF/header.jsp"/>
<div class="random-button-section">
    <button id="random-button" class="random-button" type="submit">Randomize!</button>
</div>

<div class="random-tip border p-3">
    <p>Please click the button to randomize place where to eat</p>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="resources/js/randomize.js" type="text/javascript"></script>

</body>
</html>