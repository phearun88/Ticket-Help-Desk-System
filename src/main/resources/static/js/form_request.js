var issueData = {};
var isDraft = false;
$(document).ready(function(){
	
	listMainCate();
	
	$('#mainCate').change(function() {
		var cateId = $(this).val()
		if(cateId == 0){
			$( "#subCate" ).empty();
			$( "#subCate" ).append( '<option value="">===សូមជ្រើសរើស===</option>' );
			
			return false;
		}
		listSubMenu(cateId);
	});
	
	
	$("#btnSaveRequest").click(function(){
			isDraft = false;
			saveIssues();
	});
	
	$("#btnSaveDraft").click(function(){
			isDraft = true;
			saveIssues();
	});
	
	
		
});


						  
function listMainCate(){
	
	$( "#mainCate" ).empty();
	$.ajax({ 
		    url:  "http://localhost:9988/categories/list/", 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
					$( "#mainCate" ).append( '<option value="">===សូមជ្រើសរើស===</option>' );
					$.each(data.data, function( i, v ) {
						var newCateList = '<option value="'+v.cate_id+ '">'+v.category_nm+'</option>'
						$( "#mainCate" ).append( newCateList );
						
					});
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
};


function listSubMenu(cateId){
	
	$("#subCate").empty();
	$.ajax({ 
		    url:  "http://localhost:9988/categories/sublist/"+cateId, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
					$.each(data.data, function( i, v ) {
						var newSubCateList = '<option value="'+v.sub_cate_id+ '">'+v.sub_category_nm+'</option>'
						$( "#subCate").append( newSubCateList );
					});
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
}


function getInput(){
	
	var issYn = "1";
	if(isDraft == true){
		issYn = "0";
	}
	
	var iss_nm = $("#fmrRequest #subjectTt").val().trim();
	var mainCate = $("#fmrRequest #mainCate").val();
	var subCate = $("#fmrRequest #subCate").val();
	var issueDesc = $("#fmrRequest #issueDesc").val().trim();
	var issueSt = $("#fmrRequest #issueSt").val();
	var prioritySt = $("#fmrRequest #prioritySt").val();
	
	if(mainCate == ""){
		alert("សូមជ្រើសរើស ប្រភេទសំណើរ");
		return false;
	}
	
	if(iss_nm == ""){
		alert("សូមបញ្ចូល ប្រធានបទ");
		$("#subjectTt").focus();
		return false;
	}
	
	issueData = {
				"iss_nm"			:  	iss_nm,
				"iss_cate_id"		:  	mainCate,
				"iss_subcate_id"	:  	subCate,
				"iss_desc"			:  	issueDesc,
			 	"iss_status"		:  	issueSt,
				"iss_priority"		:  	prioritySt,
				"iss_assignee"		:  	"00000",
				"iss_done"			:  	"0",
				"iss_yn"			:  	issYn,
				"user_code"			:  	$("#usrCode").val(),
				"started_date"		:  	"00000000",
				"due_date"			:  	"00000000"
	};
	
	return issueData;
	
}

function saveIssues(){

	getInput();
	if(issueData["user_code"] != null){
			$.ajax({
			    type: "POST",
			    url: "http://localhost:9988/issues/save",
			    data: JSON.stringify(issueData),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("បង្កើតសំណើរជោគជ័យ");
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
	}
}
							



