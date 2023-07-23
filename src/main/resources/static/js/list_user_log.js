var userData = {};
var usrDataDetail = {};
var chkDup = false;
var isRegAcc = false;

$(document).ready(function(){
	
		listUserLog()
	
		
		
});



function listUserLog(){
	
	$( "#userData" ).empty();
	$.ajax({ 
		    url:  "http://localhost:9988/activies/list/", 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
					$.each(data.data, function( i, v ) {
						var newList = '<tr>'
											+'<td>'+ v.user_code+'</td>'
											+"<td>"+ v.username +"</td>"
											+"<td>"+ v.authentication +"</td>"
											+"<td>"+ v.created_date +"</td>"
											
									+ "</tr>";
			   			$( "#userData" ).append( newList );
						
					});
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
}
