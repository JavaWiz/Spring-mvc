<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring MVC Autocomplete with JQuery &amp; JSON example</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />">
	<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
</head>
<body>

<h2>Spring MVC Autocomplete with JQuery &amp; JSON example</h2>
<form:form method="post" action="saveUser" modelAttribute="userForm">
<table>
	<tr>
		<th>Name</th>
		<td><form:input path="name" /></td>
	</tr>
	<tr>
		<th>Country</th>
		<td><form:input path="country" id="country" /></td>
	</tr>
	<tr>
		<th>Technologies</th>
		<td><form:input path="technologies" id="technologies" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Save" />
			<input type="reset" value="Reset" />
		</td>
	</tr>
</table>	
<br />
	
</form:form>
<br><br>
	<a href="<%=request.getContextPath()%>">Go To Home</a>
<script type="text/javascript">

$(document).ready(function() {

	$( "#country" ).autocomplete({
		source: 'get_country_list',
		autoFocus:true
	});

	$( "#technologies" ).autocomplete({
		source: 'get_tech_list',
		autoFocus:true
	});
});
</script>

</body>
</html>
