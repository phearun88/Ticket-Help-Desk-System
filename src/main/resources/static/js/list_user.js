
$(document).ready(function(){
		
		listUser()
	
		
});


						  
function listUser(){
	
	$( "#userData" ).empty();
	$.ajax({ 
		    url:  "http://localhost:9988/user/list/", 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
					console.log(data)
					$.each(data.data, function( i, v ) {
						var newList = '<tr data-rowNum="'+v.cate_id+'" data-cateNm="'+v.category_nm+ '">'
											+'<td>'+ v.user_nm_kh+'</td>'
											+"<td>"+ v.user_nm_en +"</td>"
											+"<td>"+ v.user_gender +"</td>"
											+"<td>"+ v.user_dob +"</td>"
											+"<td>"+ v.user_id_cd +"</td>"
											+"<td>"+ v.user_position +"</td>"
											+"<td>"+ v.dept_nm +"</td>"
											+"<td>"+ v.usr_tel +"</td>"
											+"<td>"+ v.usr_email +"</td>"
											+"<td>"+ v.usr_old_add +"</td>"
											+"<td>"+ v.usr_new_add +"</td>"
											
									+ "</tr>";
			   			$( "#userData" ).append( newList );
						
					});
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
}

