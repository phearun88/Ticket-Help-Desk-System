package com.example.demo.rest.restController;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.dto.ActivitiesLogDto;
import com.example.demo.repository.dto.UsersDetailDto;
import com.example.demo.repository.dto.UsersDto;
import com.example.demo.rest.request.ActivitiesLogRequestModel;
import com.example.demo.rest.request.UsersRequestModel;
import com.example.demo.rest.respone.BaseApiResponse;
import com.example.demo.rest.respone.messages.MessageProperties;
import com.example.demo.services.impl.ActivitiesLogServiceImpl;

@RestController
@RequestMapping("/activies")
public class ActivitiesLogController {

	
	@Autowired
	private ActivitiesLogServiceImpl activitiesLogServiceImpl;
	
	//Throw message error
	private MessageProperties messages;
	
	@Autowired
	public void setMessage(MessageProperties messages) {
		this.messages = messages;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<BaseApiResponse<ActivitiesLogRequestModel>> insert(
			@RequestBody ActivitiesLogDto activitiesLogDto){
		BaseApiResponse<ActivitiesLogRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		 if(activitiesLogDto.getUser_code() == null) {
			  response.setMessage(messages.nullValue("Name"));
			  response.setStatus(HttpStatus.BAD_REQUEST); 
		 }else { 
			 //usersDto.setPassword("1");
			 
			 
			 ActivitiesLogDto result = activitiesLogServiceImpl.insert(activitiesLogDto);
			 ActivitiesLogRequestModel result2 = mapper.map(result, ActivitiesLogRequestModel.class);
				response.setMessage("you have add");
				response.setData(result2);
				response.setStatus(HttpStatus.OK);
				response.setTime(null);
		 }
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/list")
	public ResponseEntity<BaseApiResponse<List<ActivitiesLogDto>>> select(){
		BaseApiResponse<List<ActivitiesLogDto>> response = new BaseApiResponse<>();

		List<ActivitiesLogDto> activitiesLogDtos = activitiesLogServiceImpl.findAll();
		response.setMessage("list data");
		response.setData(activitiesLogDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
}
