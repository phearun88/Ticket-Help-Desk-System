
$(document).ready(function(){
	
	setTimeout( function() {
		if($("#roleId").val() == 'ROLE_USER'){
			var usrCode =  $("#usrCode").val();
			listIssues(usrCode);
		}else{
			listIssuesAll("0");
		}		
	}, 500);
	
	
	$(".btnSearch").click(function(){
		
		var issuesTp = $("#issueSt").val();
		listIssuesAll(issuesTp);
	});
	
	$("#downExcel").click(function(){
		var issuesTp = $("#issueSt").val();
		
		window.location.href='/download/excel/'+issuesTp;
	});
	
	
		
		
});

						  

function listIssues(usrCode){
	$( "#issuesData" ).empty();
	$.ajax({ 
		    url:  "http://localhost:9988/issues/gettemp/"+usrCode, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
			
					$.each(data.data, function( i, v ) {
						
						var str=''
						if (v.iss_yn == "0"){
						  str =  '<a href="/request_tempEdit/'+ v.iss_id + '" class="btn btn-success btn-xs btn_chkReq">កែសំណើ</a>'
						}else if(v.iss_yn == "1"){
						  str='<a href="#" class="btn btn-success btn-xs> - o</a>'
						}
						
						var newList = '<tr data-rowNum="'+v.iss_id+'">'
											+'<td>'+ getStatus(v.iss_status)+'</td>'
											+"<td>"+ getPriority(v.iss_priority) +"</td>"
											+"<td>"+ v.iss_nm +"</td>"
											+"<td>"+ v.usersDetailDto.user_nm_kh +"</td>"
											+"<td>"+ v.categoryDto.category_nm +"</td>"
											+"<td>"+ v.subCategoryDto.sub_category_nm +"</td>"
											+"<td>"+ v.iss_done +"% </td>"
											+"<td>"+ v.updated_date +"</td>" 
											+'<td>'+str+'</td>'
									+ "</tr>";
			   			$( "#issuesData" ).append( newList );
			
						if(v.iss_status != "1"){
							$('td .btn_acceReq').attr('disabled', 'disabled');
						}
					});
		    },
		    error:function() { 

		    }
	});
};


function listIssuesAll(issuesTp){
	
	var url = "http://localhost:9988/issues/issueTp/"+issuesTp;
	if(issuesTp == "0"){
		url = "http://localhost:9988/issues/list/";
	}
	
	$( "#issuesData" ).empty();
	$.ajax({ 
		    url:  url, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
					$.each(data.data, function( i, v ) {
						
						var newList = '<tr data-rowNum="'+v.iss_id+'">'
											+'<td>'+ getStatus(v.iss_status)+'</td>'
											+"<td>"+ getPriority(v.iss_priority) +"</td>"
											+"<td>"+ v.iss_nm +"</td>"
											+"<td>"+ v.usersDetailDto.user_nm_kh +"</td>"
											+"<td>"+ v.categoryDto.category_nm +"</td>"
											+"<td>"+ v.subCategoryDto.sub_category_nm +"</td>"
											+"<td>"+ v.iss_done +" % </td>"
											+"<td>"+ v.updated_date +"</td>" 
											+'<td>'
												+'<a href="/request/'+ v.iss_id + '" class="btn btn-success btn-xs btn_chkReq">មើលសំណើ</a>'
											"</td>"
											
									+ "</tr>";
			   			$( "#issuesData" ).append( newList );
			
						if(v.iss_status != "1"){
							$('td .btn_acceReq').attr('disabled', 'disabled');
						}
					});
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
};

function getStatus(iss_status){
	var issSt ="";
	
	if(iss_status == "1"){
		issSt = "សំណើថ្មី";
	}else if(iss_status == "2"){
		issSt = "ទទួលសំណើ";
	}else if(iss_status == "3"){
		issSt = "កំពុងដោះស្រាយ";
	}else if(iss_status == "4"){
		issSt = "បានដោះស្រាយ";
	}else if(iss_status == "5"){
		issSt = "ឆ្លើយតបសំណើ";
	}else if(iss_status == "6"){
		issSt = "បិទបញ្ចប់សំណើ";
	}
	
	return issSt;
}

function getPriority(priority){
	var issPriority ="";
	
	if(priority == "1"){
		issPriority = "ធម្មតា";
	}else if(priority == "2"){
		issPriority = "ខ្ពស់";
	}else if(priority == "3"){
		issPriority = "បន្ទាន់";
	}

	return issPriority;
}


