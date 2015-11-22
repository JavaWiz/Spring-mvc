function doAjax() {
$.ajax({
  url: 'time.html',
  data: ({name : "me"}),
  success: function(data) {
    $('#time').html(data);
  },
  error:function(error){
  	alert(JSON.stringify(error));
  }
});
}

function doAjaxJSON() {
$.ajax({
  url: 'json_time',
  data: ({name : "me"}),
  success: function(data) {
    $('#time_json').html(JSON.stringify(data));
  },
  error:function(error){
  	alert(JSON.stringify(error));
  }
});
}

function getHeaderInfo() {
    $.ajax({
      url: 'reqHeaderInfo',
      success: function(data) {
      	//document.getElementById("mydiv").style.display = "block";
      	
      	$('#mydiv').show();
        	$('#mydiv').html(data);
      },
      error:function(error){alert(JSON.stringify(error));}
    });
  }

function getInfo() {
    $.ajax({
      url: 'getInfo',
      success: function(data) {
      	//document.getElementById("mydiv").style.display = "block";
      	
      	$('#mydiv').show();
        	$('#mydiv').html(data);
      },
      error:function(error){alert(JSON.stringify(error));}
    });
  }