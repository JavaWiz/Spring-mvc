<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Spring MVC Ajax Demo</title>
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
  <script src="<c:url value="/resources/js/main.js"/>"></script>
</head>
<body>
<button onclick="getHeaderInfo()" title="Button">Get Request header Information</button>
<button onclick="getInfo()" title="Button">Get Information</button>
<div id="mydiv">
</div>
<p style="margin-top: 60px"></p>
<a href="<%=request.getContextPath()%>">Go To Home</a>
</body>
</html>