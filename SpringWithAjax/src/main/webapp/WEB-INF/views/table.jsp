<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spring 3 MVC Multiple Row Submit</title>
    <link rel="stylesheet" href="./resources/css/table.css">
    <script type="text/javascript" src="./resources/js/jquery.1.10.2.min.js"></script>
    <script type="text/javascript" src="./resources/js/table.js"></script>
    <script type="text/javascript">
    	
    </script>
</head>
<body>
<h2>Spring MVC Multiple Row Form Submit example</h2>
<table id="htmlTable">
<thead>
<tr>
	<th><input type="checkbox" id="selectAllMapping" name ="selectAllMapping"></th>
    <th>No.</th>
    <th>Name</th>
    <th>Lastname</th>
    <th>Email</th>
    <th>Phone</th>
</tr>
</thead>
<tbody>
<c:forEach items="${contacts}" var="contact" varStatus="status">
<tr>
	<td align="center"><input type="checkbox" class="dataRow" name ="dataRow"></td>
    <td align="center" id="mappingId">${status.count}</td>
    <td id="firstname"><input name="contacts[${status.index}].firstname" value="${contact.firstname}"/></td>
    <td id="lastname"><input name="contacts[${status.index}].lastname" value="${contact.lastname}"/></td>
    <td id="email"><input name="contacts[${status.index}].email" value="${contact.email}"/></td>
    <td id="phone"><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>
</tr>
</c:forEach>
</tbody>
</table> 
<br/>
<input type="submit" value="Save" onclick="submitTable()"/>
<br><br>
<a href="<%=request.getContextPath()%>">Go To Home</a>
</body>
</html>