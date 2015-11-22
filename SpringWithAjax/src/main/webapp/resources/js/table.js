function submitTable(){
	var data ={ mappingId : getMappingId(),
				firstnames : getFirstnames()};
	$.ajax({
		url : 'postData',
		data : JSON.stringify(data),
		type :'POST',
		dataType :'json',
		contentType:'application/json',
		success:function(response){
			alert(response.response);
		},
		error:function(response){
			alert("Failure");
		}
		
	});
}

function getMappingId(){
	var array = [];
	var selectedCBs = $('input:checkbox.dataRow:checked');
	if (selectedCBs.length === 0) {
        alert("No rows selected to delete.");
        return;
    }
	
	selectedCBs.each(function() {
		array.push( $(this).closest('tr').children('#mappingId').text() );
    });
	alert(array)
    return array;
}

function getFirstnames(){
	/*var array = [];
	var selectedCBs = $('input:checkbox.dataRow:checked');
	if (selectedCBs.length === 0) {
        alert("No rows selected to delete.");
        return;
    }
	
	selectedCBs.each(function() {
		array.push( $(this).closest('tr').children('#firstname').find('input').val());
    });
	alert(array)
	*/
	var values = $('input:checkbox:checked.dataRow').map(function () {
		return $(this).closest('tr').children('#firstname').find('input').val();
	}).get();
	
	if (values.length === 0) {
        alert("No rows selected");
        return;
    }
	alert(values)
    return values;
}
	
$(document).ready(function() {
	$("#selectAllMapping").change(function(){
		$(".dataRow").prop('checked', $(this).prop("checked"));
	});
});
