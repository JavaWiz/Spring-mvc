<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users using ajax</title>
<link rel="stylesheet" type="text/css" href="./resources/css/ajax.user.form.css">
<script type="text/javascript" src="./resources/js/jquery.1.10.2.min.js"></script>
<script type="text/javascript" src="./resources/js/ajax.user.form.js"></script>
</head>
<body>
<h1>Add Users using Ajax ........</h1>
        <table>
                <tr><td colspan="2"><div id="error" class="error"></div></td></tr>
                <tr><td>Enter your name : </td><td> <input type="text" id="name"><br/></td></tr>
                <tr><td>Education : </td><td> <input type="text" id="education"><br/></td></tr>
                <tr><td colspan="2"><input type="button" value="Add Users" onclick="doAjaxPost()"><br/></td></tr>
                <tr><td colspan="2"><div id="info" class="success"></div></td></tr>
        </table>
</body>
</html>