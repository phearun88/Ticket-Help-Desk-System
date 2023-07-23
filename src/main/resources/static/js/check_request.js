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
		console.log(cateId);
		listSubMenu(cateId);
	});
	
	
	$('.datepicker').datepicker({
      autoclose: true
    })

	var urlUpdate = window.location.pathname;
   	var res = urlUpdate.replace("/request/", "");
	
	getIssuesDetail(res)
	
	
	$("#btnSaveRequest").click(function(){
			saveIssues();
	});
		
});


function getIssuesDetail(issuesId){
	
	
	$.ajax({ 
		    url:  "http://localhost:9988/issues/getdata/"+issuesId, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
				
				$("#subjectTt").val(data.data[0].iss_nm);
				$("#issueDesc").val(data.data[0].iss_desc);
				
				$("#issueSt").val(data.data[0].iss_status).attr("selected", true);
				$("#prioritySt").val(data.data[0].iss_priority).attr("selected", true);
				$("#done").val(data.data[0].iss_done).attr("selected", true);
				$("#iss_assignee").text(data.data[0].iss_assignee);
				$("#startDate").val(data.data[0].started_date);
				$("#endDate").val(data.data[0].due_date);
				
				listSubMenu(data.data[0].iss_cate_id);
				
				setTimeout( function() {
					$("#mainCate").val(data.data[0].iss_cate_id).attr("selected", true);
				    $("#subCate").val(data.data[0].iss_subcate_id).attr("selected", true);
					$("#issueId").val(data.data[0].iss_id);


					$('#subjectTt').attr('disabled', 'disabled');
					$('#issueDesc').attr('disabled', 'disabled');
					$('#iss_assignee').attr('disabled', 'disabled');
					$('#prioritySt').attr('disabled', 'disabled');	
					$('#mainCate').attr('disabled', 'disabled');
					$('#subCate').attr('disabled', 'disabled');
					console.log("ks")
				}, 500);

				
		    },

		    error:function() { 
		        console.log(data);
		    }
	});
	
}






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


function listSubMenu(cateId, callbackFn){
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
	
	if($.isFunction(callbackFn)){
		callbackFn();
	}
}


function getInput(){
	
	var iss_nm 		= $("#fmrRequest #subjectTt").val().trim();
	var mainCate 	= $("#fmrRequest #mainCate").val();
	var subCate		= 	$("#fmrRequest #subCate").val();
	var issueDesc 	= $("#fmrRequest #issueDesc").val().trim();
	var prioritySt 	= $("#fmrRequest #prioritySt").val();
	
	var issueSt 	= $("#fmrRequest #issueSt").val();
	var startDate	= $("#fmrRequest #startDate").val();
	var endDate 	= $("#fmrRequest #endDate").val();
	var done 		= $("#fmrRequest #done").val();
	
	
	if(startDate == ""){
		alert("សូមបញ្ចូល ថ្ងៃចាប់ផ្ដើម");
		return false;
	}
	if(endDate == ""){
		alert("សូមបញ្ចូល ថ្ងៃបញ្ចប់");
		return false;
	}
	issueData = {
				"iss_id"			:  	$("#issueId").val(),
				"iss_nm"			:  	iss_nm,
				"iss_cate_id"		:  	mainCate,
				"iss_subcate_id"	:  	subCate,
				"iss_desc"			:  	issueDesc,
			 	"iss_status"		:  	issueSt,
				"iss_priority"		:  	prioritySt,
				"iss_assignee"		:  	$("#usrCode").val(),
				"iss_done"			:  	done,
				"iss_yn"			:  	"1",
				"user_code"			:  	$("#usrCode").val(),
				"started_date"		:  	startDate,
				"due_date"			:  	endDate
	};
	return issueData;
}

function saveIssues(){
	
	getInput();
	
	if(issueData["iss_id"] != null){
		
			$.ajax({
			    type: "PUT",
			    url: "http://localhost:9988/issues/update",
			    data: JSON.stringify(issueData),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("ផ្លាស់ប្ដូរបានជោគជ័យ");
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
	}
}
							



