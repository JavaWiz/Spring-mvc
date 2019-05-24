<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
</head>
<body>
	<div id="msg"></div>
	<button onclick="doAjax()" title="Button">Get the time!</button>
	<button onclick="doAjaxJSON()" title="Button">Get the time!</button>
	<div id="time"></div>
	<div id="time_json"></div>
	<p style="margin-top: 60px"></p>
	<a href="<%=request.getContextPath()%>">Go To Home</a>
</body>
</html>