$(document).ready(function(){
	
	$('.datepicker').datepicker({
      autoclose: true
    })

	setTimeout( function() {
		userDeatil();
	}, 500);
	
		
	$("#btnSubUsrDetail").click(function(){
		updateUserDetail();
	});
});


function userDeatil(){
	
	var user_code =$("#usrCode").val();
	$.ajax({ 
		    url:  "http://localhost:9988/user/myinfor/"+user_code, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
				
				var oldAdd = data.data[0].usr_old_add;
				var oldAddArr = oldAdd.split(',');
				var newAdd = data.data[0].usr_new_add;
				var newAddArr = newAdd.split(',');
				
				$("#userNmKh").val(data.data[0].user_nm_kh);
				$("#userNmEn").val(data.data[0].user_nm_en);
				$("#userGen").val(data.data[0].user_gender).attr("selected", true);
				$("#userDob").val(data.data[0].user_dob);
				$("#userIdCd").val(data.data[0].user_id_cd);
				$("#userPosition").val(data.data[0].user_position);
				$("#deptNm").val(data.data[0].dept_nm);
				$("#usrTel").val(data.data[0].usr_tel);
				$("#usrEmail").val(data.data[0].usr_email);
				
				
				$("#usrOldPro").val(oldAddArr[0]);
				$("#usrOldDist").val(oldAddArr[1]);
				$("#usrOldComm").val(oldAddArr[2]);
				$("#usrOldVill").val(oldAddArr[3]);
				
				$("#usrNewPro").val(newAddArr[0]);
				$("#usrNewDist").val(newAddArr[1]);
				$("#usrNewComm").val(newAddArr[2]);
				$("#usrNewVill").val(newAddArr[3]);
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
}


function getInput(){
	var userNmKh = $("#fmUsrDetail #userNmKh").val().trim();
	var userNmEn = $("#fmUsrDetail #userNmEn").val().trim();
	var userDob =  $("#fmUsrDetail #userDob").val().trim();
	var userIdCd = $("#fmUsrDetail #userIdCd").val().trim();
	var userPosition = $("#fmUsrDetail #userPosition").val().trim();
	var deptNm = $("#fmUsrDetail #deptNm").val().trim();
	
	if(userNmKh == ""){
		alert("សូមបញ្ចូល នាមត្រកូល-នាម");
		$("#userNmKh").focus();
		return false;
	}
	
	var userOldAdd = $("#usrOldPro").val() +","+ $("#usrOldDist").val() +","+ $("#usrOldComm").val() +","+ $("#usrOldVill").val();
	var userNewAdd = $("#usrNewPro").val() +","+ $("#usrNewDist").val() +","+ $("#usrNewComm").val() +","+ $("#usrNewVill").val();
	
	usrDataDetail = {
				"user_code"		:  	$("#usrCode").val(),
				"user_nm_kh"	:  	userNmKh,
			  	"user_nm_en"	:  	userNmEn,
				"user_gender"	:  	$("#userGen").val(),
				"user_dob"		:  	userDob,
			 	"user_id_cd"	:  	userIdCd,
				"user_position"	:  	userPosition,
				"dept_nm"		:  	deptNm,
				"usr_old_add"	:  	userOldAdd,
				"usr_new_add"	:  	userNewAdd,
				"usr_tel"		:  	$("#usrTel").val().trim(),
				"usr_email"		:  	$("#usrEmail").val().trim()
	};
	
	return usrDataDetail;
	
}


function updateUserDetail(){
	getInput();
	
	if(usrDataDetail["user_code"] != null){
		
			$.ajax({
			    type: "PUT",
			    url: "http://localhost:9988/user/update",
			    data: JSON.stringify(usrDataDetail),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("ព័ត៌មានអ្នកប្រើប្រាស់ត្រូវបានកែប្រែ");
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
	}
}
		