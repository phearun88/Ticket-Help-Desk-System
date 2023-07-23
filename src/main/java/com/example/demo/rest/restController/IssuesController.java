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

import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.rest.request.IssuesRequestModel;
import com.example.demo.rest.respone.BaseApiResponse;
import com.example.demo.rest.respone.messages.MessageProperties;
import com.example.demo.services.impl.IssuesServiceImpl;


@RestController
@RequestMapping("/issues")
public class IssuesController {

	@Autowired
	private IssuesServiceImpl issuesServiceImpl;
	
	//Throw message error
	private MessageProperties messages;
	
	@Autowired
	public void setMessage(MessageProperties messages) {
		this.messages = messages;
	}
	
	@PostMapping("/save")
	public ResponseEntity<BaseApiResponse<IssuesRequestModel>> insert(
			@RequestBody IssuesDto issuesDto){
		BaseApiResponse<IssuesRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		System.out.println("===============dataNullllll=============" + issuesDto.getIss_nm());
		 if(issuesDto.getUser_code() == null) {
			  response.setMessage(messages.nullValue("Name"));
			  response.setStatus(HttpStatus.BAD_REQUEST); 
		 }else { 
			 
			 IssuesDto result = issuesServiceImpl.insert(issuesDto);
			 IssuesRequestModel result2 = mapper.map(result, IssuesRequestModel.class);
				response.setMessage("you have add");
				response.setData(result2);
				response.setStatus(HttpStatus.OK);
				response.setTime(null);
		 }
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/list")
	public ResponseEntity<BaseApiResponse<List<IssuesDto>>> select(){
		BaseApiResponse<List<IssuesDto>> response = new BaseApiResponse<>();

		List<IssuesDto> issuesDtos = issuesServiceImpl.findAll();
		
		System.out.println("=================DATA: ======");

		response.setMessage("list data");
		response.setData(issuesDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<BaseApiResponse<IssuesRequestModel>> update(
			@RequestBody IssuesRequestModel issuesRequestModel){
		BaseApiResponse<IssuesRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		IssuesDto issuesDto = mapper.map(issuesRequestModel, IssuesDto.class);
		
		if(issuesRequestModel.getIss_status() == null) {
			response.setMessage(messages.nullValue("Name"));
            response.setStatus(HttpStatus.BAD_REQUEST);
		}else {
			
			IssuesDto result = issuesServiceImpl.update(issuesDto);
			IssuesRequestModel result2 = mapper.map(result, IssuesRequestModel.class);
			response.setMessage("you have Update");
			response.setData(result2);
			response.setStatus(HttpStatus.OK);
			response.setTime(null);
		}
		
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/getdata/{issuesId}")
	public ResponseEntity<BaseApiResponse<List<IssuesDto>>> select(@PathVariable int issuesId){
		BaseApiResponse<List<IssuesDto>> response = new BaseApiResponse<>();

		List<IssuesDto> issuesDtos = issuesServiceImpl.select(issuesId);
		
		response.setMessage("list data");
		response.setData(issuesDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/gettemp/{user_code}")
	public ResponseEntity<BaseApiResponse<List<IssuesDto>>> select1(@PathVariable String user_code){
		BaseApiResponse<List<IssuesDto>> response = new BaseApiResponse<>();

		List<IssuesDto> issuesDtos = issuesServiceImpl.select1(user_code);
		
		response.setMessage("list data");
		response.setData(issuesDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/issueTp/{iss_status}")
	public ResponseEntity<BaseApiResponse<List<IssuesDto>>> select2(@PathVariable String iss_status){
		BaseApiResponse<List<IssuesDto>> response = new BaseApiResponse<>();

		List<IssuesDto> issuesDtos = issuesServiceImpl.select2(iss_status);

		response.setMessage("list data");
		response.setData(issuesDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
}
