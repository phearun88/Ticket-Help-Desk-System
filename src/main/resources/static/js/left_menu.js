$(document).ready(function(){
	var userNm = sessionStorage.getItem('USER');
	
	
	getUserDetail(userNm);
	
	
});


function fnActLog(userNm){
	var dataLog = {};
	dataLog = {
				"username":  	userNm,
				"user_code":  	$("#usrCode").val().trim(),
				"authentication":  	$("#roleId").val().trim()
	};
	
	if(dataLog["username"] != null){
			$.ajax({
			    type: "POST",
			    url: "http://localhost:9988/activies/save",
			    data: JSON.stringify(dataLog),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					sessionStorage.removeItem('ACT');
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
		}
	
}


function getUserDetail(userNm){
	
	$.ajax({ 
		    url:  "http://localhost:9988/user/chk/"+userNm, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
				//console.log(data);
				var roleTp = data.data[0].authentication;
				var usrCode = data.data[0].user_code;
				$("#roleId").val(roleTp);
				$("#usrCode").val(usrCode);
				
				var newList = '<a href="/myinfor" class="usrNm">'+userNm+'</a>';
				$( "#userNmTt" ).append( newList );
				
				
				
				if(roleTp == "ROLE_ADMIN" || roleTp == "ROLE_EDITOR"){
					$("#blockUser").empty();
					$("#blockAdmin").css("display", "block"); 
					$("#downExcel").css("display", "block");
					$("#searchIssue").css("display", "block");
				}else if(roleTp == "ROLE_USER"){
					$("#blockAdmin").empty();
					$("#searchIssue").empty();
					$("#blockAdminChkLog").empty();
					$("#blockUser").css("display", "block");
				}
				
				var actLog = sessionStorage.getItem('ACT');
				
				if(actLog == "1"){
					fnActLog(userNm);
				}
				
		    },

		    error:function() { 
		        console.log(data);
		    }
	});
}
