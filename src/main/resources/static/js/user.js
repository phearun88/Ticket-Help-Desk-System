var userData = {};
var usrDataDetail = {};
var chkDup = false;
var isRegAcc = false;

$(document).ready(function(){
	
		$("#btnSaveUser").click(function(){
			//alert("test");
			if(chkDup == false){
				alert("សូមធ្វើការចុចប៊ូតុងត្រួតពិនិត្យអ៊ីម៉ែលសិន");
				return false;
			}
			registerUser();
		});
	
		$("#btnChkDup").click(function(){
			checkUserDup();
		});
		
		
		$("#btnSubUsrDetail").click(function(){
			if(isRegAcc == false){
				alert("សូមមេត្តាធ្វើការចុះឈ្មោះគណនីជាមុនសិន");
				$("#inforTab").click();
				return false;
			}
			updateUserDetail();
			
		});
		
		$('.datepicker').datepicker({
	      autoclose: true
	    })
		
});

function checkUserDup(){
	var userNm = $("#userNm").val();
	if(userNm == ""){
		alert("សូមបញ្ចូលអ៊ីម៉ែល");
		$("#userNm").focus();
		return false;
	}
	$.ajax({ 
		    url:  "http://localhost:9988/user/chk/"+userNm, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
				var dat = data.data.length;
				if(dat == 1){
					alert("ឈ្មោះគណនីមានរួចហើយ");
					$("#userEmail").focus();
					return false;
					
				}else{
					alert("ឈ្មោះគណនីអាចប្រើបាន")
					$('#userNm').attr('disabled', 'disabled');
					$('#btnChkDup').attr('disabled', 'disabled');
					chkDup = true;
					return false;
				}
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
}


function registerUser(){
		var userNm 		= $("#fmRegisUser #userNm").val().trim();
		var usersPwd 	= $("#fmRegisUser #usersPwd").val().trim();
		var conUserPwd 	= $("#fmRegisUser #conUserPwd").val().trim();
		var userRole 	= $("#fmRegisUser #userRole").val().trim();
	
		if(userNm == ""){
			alert("សូមបញ្ចូលឈ្មោះគណនី");
			$("#userNm").focus();
			return false;
		}
		if(usersPwd == ""){
			alert("សូមបញ្ចូលលេខសំងាត់");
			$("#usersPwd").focus();
			return false;
		}
		if(conUserPwd == ""){
			alert("សូមបញ្ចូលបញ្ជាក់លេខសំងាត់");
			$("#conUserPwd").focus();
			return false;
		}
		if(usersPwd != conUserPwd){
			alert("លេខសំងាត់ និងបញ្ជាក់ត្រូវតែដូចគ្នា");
			$("#usersPwd").focus();
			return false;
		}
		var txtUserCode = new Date().getTime();
		 $("#userCode").val(txtUserCode);
		userData = {
				  "user_code"		: $("#userCode").val(),
				  "username"		: userNm,
				  "password"		: usersPwd,
			      "authentication"	:  userRole
				 };
		$.ajax({
				type: "POST",
				url: "http://localhost:9988/user/save",
			    data: JSON.stringify(userData),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					isRegAcc = true;
					
					saveUserDetail();
					
				},
			    error: function(errMsg) {
			        alert(errMsg);
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
				"user_code"		:  	$("#userCode").val(),
				"user_nm_kh"	:  	userNmKh,
			  	"user_nm_en"	:  	userNmEn,
				"user_gender"	:  	$("#userGen").val(),
				"user_dob"		:  	userDob,
			 	"user_id_cd"	:  	userIdCd,
				"user_position"	:  	userPosition,
				"dept_nm"		:  	deptNm,
				"usr_old_add"	:  	userOldAdd,
				"usr_new_add"	:  	userNewAdd,
				"usr_tel"		:  	$("#fmUsrDetail #usrTel").val().trim(),
				"usr_email"		:  	$("#fmUsrDetail #usrEmail").val().trim()
	};
	return usrDataDetail;
	
}


function saveUserDetail(){
	
	usrDataDetail = {
				"user_code"		:  	$("#userCode").val(),
				"user_nm_kh"	:  	$("#userNm").val(),
			  	"user_nm_en"	:  	"",
				"user_gender"	:  	"",
				"user_dob"		:  	"",
			 	"user_id_cd"	:  	"",
				"user_position"	:  	"",
				"dept_nm"		:  	"",
				"usr_old_add"	:  	",,,",
				"usr_new_add"	:  	",,,",
				"usr_tel"		:  	"",
				"usr_email"		:  	""
	};
	
	//getInput();
	if(usrDataDetail["user_code"] != null){
			$.ajax({
			    type: "POST",
			    url: "http://localhost:9988/user/saveusrdetail",
			    data: JSON.stringify(usrDataDetail),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("ចុះឈ្មោះគណនីបានជោគជ័យ");
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
	}
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


