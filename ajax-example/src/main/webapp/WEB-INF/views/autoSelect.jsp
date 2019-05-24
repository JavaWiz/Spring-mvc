<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>jQuery Populate City Dropdown Based on Country Selected</title>
<link rel="stylesheet" href="./resources/css/jquery.mobile-1.4.5.min.css">
<style type="text/css">
.container{
	margin:50px 400px 0px 400px;
}

.country .state{
	width:200px;
}

</style>
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js"/>"></script>
<script src="./resources/js/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("select.country").change(function(){
        var selectedCountry = $(".country option:selected").val();
        $('.state').empty();
        /* $.ajax({
            type: "GET",
            url: "states",
            data: { country : selectedCountry } 
        }).done(function(data){
        	$('.state').append('<option value="">-- Select --</option>');
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				$('.state').append('<option value="' + data[i] + '">'
						+ data[i] + '</option>');
			}
			$('select.state').selectmenu('refresh');
        }); */
        
        $.getJSON('./states?country='+$(".country option:selected").val(), function( response ){
        	$('.state').append('<option value="">-- Select --</option>');
			var len = response.length;
			for ( var i = 0; i < len; i++) {
				$('.state').append('<option value="' + response[i] + '">'
						+ response[i] + '</option>');
			}
			$('select.state').selectmenu('refresh');
        })
    });
});
</script>
</head>
<body>
	<div class="container">
    <table>
        <tr>
            <td>
                <label for="country">Country:</label>
            </td>
            <td>
                <select name="country" class="country" data-native-menu="false">
                    <option>-- Select --</option>
                    <c:forEach items="${countries}" var="country">
                    <option value="${country}">${country}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <label for="state">States:</label>
            </td>
            <td>
                <select name="state" class="state" data-native-menu="false">
                <option value="">-- Select --</option>
                </select>
            </td>
        </tr>
    </table>
    <br><br>
	<a href="<%=request.getContextPath()%>">Go To Home</a>
    </div>
</body> 
</html>