<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
Table.GridOne {
	padding: 3px;
	margin: 0;
	background: lightyellow;
	border-collapse: collapse;	
	width:35%;
}
Table.GridOne Td {	
	padding:2px;
	border: 1px solid #ff9900;
	border-collapse: collapse;
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
function madeAjaxCall(){
	$.ajax({
		type: "post",
		url: "addUser.do",
		cache: false,				
		data:'firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val(),
		success: function(result){
			$('#result').html("First Name:- " + result.firstName +"</br>Last Name:- " + result.lastName  + "</br>Email:- " + result.email);
		},
		error: function(){						
			alert('Error while request..');
		}
	});
}
function sendJsonData(){
	/*var firstName = $("#firstName").val(),lastName = $("#lastName").val(),email = $("#email").val();*/
	$.ajax({
		type: "post",
		url: "addJsonUser",
		contentType: "application/json",
		cache: false,				
		data:JSON.stringify({"firstName" : $("#firstName").val(), "lastName" : $("#lastName").val(), "email" : $("#email").val()}),
		success: function(result){
			$('#result').html("First Name:- " + result.firstName +"</br>Last Name:- " + result.lastName  + "</br>Email:- " + result.email);
		},
		error: function(e){						
			alert('Error while request..'+JSON.stringify(e));
		}
	});
}

</script>
</head>
<body>
	<form name="employeeForm" method="post">	
		<table cellpadding="0" cellspacing="0" border="1" class="GridOne">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" id="firstName" value=""></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" id="lastName" value=""></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="Ajax Submit" onclick="madeAjaxCall()"></td>
				<td colspan="2" align="center"><input type="button" value="Ajax Json Submit" onclick="sendJsonData()"></td>
			</tr>
		</table>
	</form>
	<div id="result"></div>
	<p style="margin-top: 60px"></p>
	<a href="<%=request.getContextPath()%>">Go To Home</a>
</body>
</html>