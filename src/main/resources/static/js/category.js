
var isChkSave = false;
var dataCate  = {};
var dataSubCate  = {};
$(document).ready(function(){
	
	
	/*************
	* Loading
	*************/
		//ListCate
		listCategory();
		
		
	/*************
	* Evert
	*************/	
		
	//SaveCatePopUp
	$("#addCate").click(function(){
		if($("#cateNm").val().trim() == ""){
			alert("សូមបញ្ចូលប្រភេទសំណើរ");
			$("#cateNm").focus();
			return false;
		}
		saveCategory();
	});
	

	//SubCatePopUp
	$(document).delegate(".btn_addSubCate_pop","click",function(){
		var cateId 	= $(this).parents("tr").attr("data-rownum");
		var cateNm 	= $(this).parents("tr").attr("data-cateNm");
		
		$("#mainCateNm").text(cateNm);
		$("#mainCateId").val(cateId);
		
		listSubCategory(cateId);
		
	});
	
	//suspendCate
	$(document).delegate(".btn_suspend_cat","click",function(){
		var cateId 	= $(this).parents("tr").attr("data-rownum");
		
		if (confirm('តើអ្នកពិតជាចង់បិទសំណើនេះមែនទេ?')) {
		 	suspendCate(cateId);
		}
	});
	
	$(document).delegate(".btn_suspend_subcat","click",function(){
		var subcateId 	= $(this).parents("tr").attr("data-rownum");
		
		if (confirm('តើអ្នកពិតជាចង់បិទសំណើនេះមែនទេ?' +subcateId)) {
		 	suspendSubCate(subcateId);
		}
	});
	

 	//SaveSubCate
	$("#addSubCate").click(function(){
		if($(".subCategNm").val().trim() == ""){
				alert("សូមបញ្ចូលប្រភេទសំណើររង");
				$(".subCategNm").focus();
				return false;
		}
		saveSubCategory();
	});
	
		
});


function saveCategory(){
	
	dataCate = {
				"category_nm":  	$("#cateNm").val().trim(),
				"user_id":  	$("#usrCode").val().trim()
	};
	console.log(dataCate);
	
	if(dataCate["category_nm"] != null){
			$.ajax({
			    type: "POST",
			    url: "http://localhost:9988/categories/save",
			    data: JSON.stringify(dataCate),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("បញ្ចូលប្រភេទសំណើជោគជ័យ");
					$(".btn_cls").click();
					$("#cateNm").val("");
					
					listCategory();
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
		}
		
}
 

function listCategory(){
	
	$( "#cateDataList" ).empty();
	$.ajax({ 
		    url:  "http://localhost:9988/categories/list/", 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
					$.each(data.data, function( i, v ) {
						var newList = '<tr data-rowNum="'+v.cate_id+'" data-cateNm="'+v.category_nm+ '">'
											+'<td>'+ v.category_nm+'</td>'
											+"<td>"+ getCateSt(v.category_st) +"</td>"
											+"<td>"
												+'<button type="button" class="btn btn-default btn-xs btn_addSubCate_pop" data-toggle="modal" data-target="#modal-addSubCate"> សំណើររង </button>' 
												+'<button type="button" class="btn btn-default btn-xs btn_suspend_cat"> បិទ </button>'
											"</td>"
									+ "</tr>";
			   			$( "#cateDataList" ).append( newList );
						
					});
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
}



function saveSubCategory(){
	
	dataSubCate = {
				"sub_category_nm"	:  	$(".subCategNm").val().trim(),
				"cate_id"			:  	$("#mainCateId").val().trim(),
				"user_id"			:  	$("#usrCode").val().trim()
	};
	console.log(dataSubCate);
	
	if(dataSubCate["sub_category_nm"] != null){
			console.log("regist");
			$.ajax({
			    type: "POST",
			    url: "http://localhost:9988/categories/savesubcate",
			    data: JSON.stringify(dataSubCate),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("បញ្ចូលប្រភេទសំណើរងជោគជ័យ");
					var sub_cate_id_temp ="2";
					var sub_category_nm_temp = $(".subCategNm").val().trim();
					var sub_category_st_temp = "1";
					
					var newList = '<tr data-rowNum="'+sub_cate_id_temp+'">'
										+'<td>'+ sub_category_nm_temp+'</td>'
										+"<td>"+ getCateSt(sub_category_st_temp )+"</td>"
										+"<td>"
											+'<button type="button" class="btn btn-default btn-xs"> បិទ </button>'
										"</td>"
								+ "</tr>";
		   			$( "#subCateDataList" ).append( newList );
		
					$(".subCategNm").val("").focus();
					
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
		}
		
}

function listSubCategory(cateId){
	
	$( "#subCateDataList" ).empty();
	$.ajax({ 
		    url:  "http://localhost:9988/categories/sublist/"+cateId, 
		    type: "GET",
		    beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
		    success: function(data) { 
					$.each(data.data, function( i, v ) {
						var newList = '<tr data-rowNum="'+v.sub_cate_id+'">'
											+'<td>'+ v.sub_category_nm+'</td>'
											+"<td>"+ getCateSt(v.sub_category_st) +"</td>"
											+"<td>"
												+'<button type="button" class="btn btn-default btn-xs btn_suspend_subcat"> បិទ </button>'
											"</td>"
									+ "</tr>";
			   			$( "#subCateDataList" ).append( newList );
						
					});
		    },
		    error:function() { 
		        console.log(data);
		    }
	});
}



function suspendCate(catId){
	var cateData= {};
	cateData = { "cate_id": catId, 
				"category_st" : "0"
			}
			
	if(cateData["cate_id"] != null){
		
			$.ajax({
			    type: "PUT",
			    url: "http://localhost:9988/categories/update",
			    data: JSON.stringify(cateData),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("បិទសំណើជោគជ័យ");
					listCategory();
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
	}
}

function suspendSubCate(subcatId){
	var subcateData= {};
	subcateData = { "sub_cate_id": subcatId, 
					"sub_category_st" : "0"
				  }
			
	if(subcateData["sub_cate_id"] != null){
		
			$.ajax({
			    type: "PUT",
			    url: "http://localhost:9988/categories/updatesubcate",
			    data: JSON.stringify(subcateData),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
					alert("បិទសំណើជោគជ័យ");
					listCategory();
				},
			    error: function(errMsg) {
			        alert(errMsg);
			    }
			});
	}
}



function getCateSt(catSt){
	
	var catStTxt ="";
	if(catSt == 1){
		catStTxt = "នៅប្រើ";
	}else{
		catStTxt = "ឈប់ប្រើ"
	}
	return catStTxt;
	
}

