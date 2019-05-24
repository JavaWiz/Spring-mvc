function doAjaxPost() {
    // get the form values
    var name = $('#name').val();
    var education = $('#education').val();
    alert(name +" & "+education)
    var data ={name: name, education: education};
    
    $.ajax({
        type: "POST",
        url: "addAjaxUser",
        data: JSON.stringify(data),
        dataType:'json',
        contentType:'application/json',
        success: function(response){alert(response.status);
        alert(JSON.stringify(response))
            if(response.status == "SUCCESS"){
                userInfo = "<ol>";
                alert(response.result.length)
                for(i =0 ; i < response.result.length ; i++){
                    userInfo += "<br><li><b>Name</b> : " + response.result[i].name +
                    ";<b> Education</b> : " + response.result[i].education;
                 }
                 userInfo += "</ol>";
                 $('#info').html("User has been added to the list successfully. " + userInfo);
                 $('#name').val('');
                 $('#education').val('');
                 $('#error').hide('slow');
                 $('#info').show('slow');
             }else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#info').hide('slow');
                 $('#error').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
}