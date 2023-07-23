package com.example.demo.rest.restController;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.dto.CategoryDto;
import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.repository.dto.SubCategoryDto;
import com.example.demo.rest.request.CategoryRequestModel;
import com.example.demo.rest.request.IssuesRequestModel;
import com.example.demo.rest.request.SubCategoryRequestModel;
import com.example.demo.rest.respone.BaseApiResponse;
import com.example.demo.rest.respone.messages.MessageProperties;
import com.example.demo.services.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	//Throw message error
	private MessageProperties messages;
	
	@Autowired
	public void setMessage(MessageProperties messages) {
		this.messages = messages;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<BaseApiResponse<CategoryRequestModel>> insert(
			@RequestBody CategoryDto categoryDto){
		BaseApiResponse<CategoryRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		System.out.println("===============dataNullllll=============" + categoryDto.getCategory_nm());
		 if(categoryDto.getCategory_nm() == null) {
			  response.setMessage(messages.nullValue("Name"));
			  response.setStatus(HttpStatus.BAD_REQUEST); 
		 }else { 
			// int usrId = 1;
			 categoryDto.setCategory_st("1");
			 //categoryDto.setUser_id(usrId);
			 CategoryDto result = categoryServiceImpl.insert(categoryDto);
			 CategoryRequestModel result2 = mapper.map(result, CategoryRequestModel.class);
				response.setMessage("you have add");
				response.setData(result2);
				response.setStatus(HttpStatus.OK);
				response.setTime(null);
		 }
		return ResponseEntity.ok(response);	
	}
	
	@PostMapping("/savesubcate")
	public ResponseEntity<BaseApiResponse<SubCategoryRequestModel>> insert1(
			@RequestBody SubCategoryDto subCategoryDto){
		BaseApiResponse<SubCategoryRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		System.out.println("===============dataNullllll=============" + subCategoryDto.getSub_category_nm());
		 if(subCategoryDto.getSub_category_nm() == null) {
			  response.setMessage(messages.nullValue("Name"));
			  response.setStatus(HttpStatus.BAD_REQUEST); 
		 }else { 
			// int usrId = 1;
			 subCategoryDto.setSub_category_st("1");
			 //subCategoryDto.setUser_id(usrId);
			 SubCategoryDto result = categoryServiceImpl.insert1(subCategoryDto);
			 SubCategoryRequestModel result2 = mapper.map(result, SubCategoryRequestModel.class);
				response.setMessage("you have add");
				response.setData(result2);
				response.setStatus(HttpStatus.OK);
				response.setTime(null);
		 }
		return ResponseEntity.ok(response);	
	}

	@GetMapping("/list")
	public ResponseEntity<BaseApiResponse<List<CategoryDto>>> select(){
		BaseApiResponse<List<CategoryDto>> response = new BaseApiResponse<>();

		List<CategoryDto> categoryDtos = categoryServiceImpl.findAll();
		
		System.out.println("=================DATA: ======");

		response.setMessage("list data");
		response.setData(categoryDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/sublist/{cateId}")
	public ResponseEntity<BaseApiResponse<List<SubCategoryDto>>> select(@PathVariable int cateId){
		BaseApiResponse<List<SubCategoryDto>> response = new BaseApiResponse<>();

		List<SubCategoryDto> subCategoryDtos = categoryServiceImpl.select(cateId);
		
		System.out.println("=================DATA: ======"+categoryServiceImpl);

		response.setMessage("list data");
		response.setData(subCategoryDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<BaseApiResponse<CategoryRequestModel>> update(
			@RequestBody CategoryRequestModel categoryRequestModel){
		BaseApiResponse<CategoryRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		CategoryDto categoryDto = mapper.map(categoryRequestModel, CategoryDto.class);
		
		if(categoryRequestModel.getCategory_st()== null) {
			response.setMessage(messages.nullValue("Name"));
            response.setStatus(HttpStatus.BAD_REQUEST);
		}else {
			
			CategoryDto result = categoryServiceImpl.update(categoryDto);
			CategoryRequestModel result2 = mapper.map(result, CategoryRequestModel.class);
			response.setMessage("you have Update");
			response.setData(result2);
			response.setStatus(HttpStatus.OK);
			response.setTime(null);
		}
		return ResponseEntity.ok(response);	
	}
	
	@PutMapping("/updatesubcate")
	public ResponseEntity<BaseApiResponse<SubCategoryRequestModel>> update(
			@RequestBody SubCategoryRequestModel subCategoryRequestModel){
		BaseApiResponse<SubCategoryRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		SubCategoryDto subCategoryDto = mapper.map(subCategoryRequestModel, SubCategoryDto.class);
		
		if(subCategoryRequestModel.getSub_category_st()== null) {
			response.setMessage(messages.nullValue("Name"));
            response.setStatus(HttpStatus.BAD_REQUEST);
		}else {
			
			SubCategoryDto result = categoryServiceImpl.update1(subCategoryDto);
			SubCategoryRequestModel result2 = mapper.map(result, SubCategoryRequestModel.class);
			response.setMessage("you have Update");
			response.setData(result2);
			response.setStatus(HttpStatus.OK);
			response.setTime(null);
		}
		return ResponseEntity.ok(response);	
	}
}
