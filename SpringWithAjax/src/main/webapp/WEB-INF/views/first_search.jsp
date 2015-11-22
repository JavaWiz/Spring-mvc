<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
</head>
<body>
	<h2>Spring MVC + jQuery + Autocomplete example</h2>

	<div>
		<input type="text"  id="input-search" value="">
		<span>
			<button id="w-button-search" type="button">Search</button>
		</span>
	</div>
	<br><br>
	<a href="<%=request.getContextPath()%>">Go To Home</a>
	<script>
	$(document).ready(function() {

		$('#input-search').autocomplete({
			serviceUrl: 'getTags',
			paramName: "tagName",
			delimiter: ",",
		    transformResult: function(response) {
		    	
		        return {
		        	
		            suggestions: $.map($.parseJSON(response), function(item) {
		            	
		                return { value: item.tagName, data: item.id };
		            })  
		        };   
		    } 
		});
	});
	</script>
</body>
</html>