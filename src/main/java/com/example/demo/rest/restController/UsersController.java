package com.example.demo.rest.restController;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.repository.dto.UsersDetailDto;
import com.example.demo.repository.dto.UsersDto;
import com.example.demo.rest.request.IssuesRequestModel;
import com.example.demo.rest.request.UsersDetailRequestModel;
import com.example.demo.rest.request.UsersRequestModel;
import com.example.demo.rest.respone.BaseApiResponse;
import com.example.demo.rest.respone.messages.MessageProperties;
import com.example.demo.services.impl.UsersServiceImpl;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	//Throw message error
	private MessageProperties messages;
	
	@Autowired
	public void setMessage(MessageProperties messages) {
		this.messages = messages;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/save")
	public ResponseEntity<BaseApiResponse<UsersRequestModel>> insert(
			@RequestBody UsersDto usersDto){
		BaseApiResponse<UsersRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		System.out.println("===============dataNullllll=============" + usersDto.getUsername());
		 if(usersDto.getUser_code() == null) {
			  response.setMessage(messages.nullValue("Name"));
			  response.setStatus(HttpStatus.BAD_REQUEST); 
		 }else { 
			 //usersDto.setPassword("1");
			 
			 usersDto.setPassword(passwordEncoder.encode(usersDto.getPassword()));
			 
			 UsersDto result = usersServiceImpl.insert(usersDto);
			 UsersRequestModel result2 = mapper.map(result, UsersRequestModel.class);
				response.setMessage("you have add");
				response.setData(result2);
				response.setStatus(HttpStatus.OK);
				response.setTime(null);
		 }
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/chk/{username}")
	public ResponseEntity<BaseApiResponse<List<UsersDto>>> select(@PathVariable String username){
		BaseApiResponse<List<UsersDto>> response = new BaseApiResponse<>();

		List<UsersDto> usersDto = usersServiceImpl.selectById(username);
		
		System.out.println("=================DATA: ======"+username);

		response.setMessage("list data");
		response.setData(usersDto);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	@PostMapping("/saveusrdetail")
	public ResponseEntity<BaseApiResponse<UsersDetailRequestModel>> insert1(
			@RequestBody UsersDetailDto usersDetailDto){
		BaseApiResponse<UsersDetailRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		System.out.println("===============dataNullllll=============" + usersDetailDto.getUser_code());
		 if(usersDetailDto.getUser_code() == null) {
			  response.setMessage(messages.nullValue("Name"));
			  response.setStatus(HttpStatus.BAD_REQUEST); 
		 }else { 
			 //usersDto.setPassword("1");
			 
			 UsersDetailDto result = usersServiceImpl.insert1(usersDetailDto);
			 UsersDetailRequestModel result2 = mapper.map(result, UsersDetailRequestModel.class);
				response.setMessage("you have add");
				response.setData(result2);
				response.setStatus(HttpStatus.OK);
				response.setTime(null);
		 }
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/list")
	public ResponseEntity<BaseApiResponse<List<UsersDetailDto>>> select(){
		BaseApiResponse<List<UsersDetailDto>> response = new BaseApiResponse<>();

		List<UsersDetailDto> usersDetailDtos = usersServiceImpl.findAll();
		response.setMessage("list data");
		response.setData(usersDetailDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/myinfor/{user_code}")
	public ResponseEntity<BaseApiResponse<List<UsersDetailDto>>> select1(@PathVariable String user_code){
		BaseApiResponse<List<UsersDetailDto>> response = new BaseApiResponse<>();

		List<UsersDetailDto> usersDetailDtos = usersServiceImpl.select1(user_code);

		response.setMessage("list data");
		response.setData(usersDetailDtos);
		response.setStatus(HttpStatus.OK);
		response.setTime(null);
		
		return ResponseEntity.ok(response);	
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<BaseApiResponse<UsersDetailRequestModel>> update(
			@RequestBody UsersDetailRequestModel usersDetailRequestModel){
		BaseApiResponse<UsersDetailRequestModel> response = new BaseApiResponse<>();
		ModelMapper mapper = new ModelMapper();
		UsersDetailDto usersDetailDto = mapper.map(usersDetailRequestModel, UsersDetailDto.class);
		
		if(usersDetailRequestModel.getUser_code() == null) {
			response.setMessage(messages.nullValue("Name"));
            response.setStatus(HttpStatus.BAD_REQUEST);
		}else {
			
			UsersDetailDto result = usersServiceImpl.update(usersDetailDto);
			UsersDetailRequestModel result2 = mapper.map(result, UsersDetailRequestModel.class);
			response.setMessage("you have Update");
			response.setData(result2);
			response.setStatus(HttpStatus.OK);
			response.setTime(null);
		}
		
		return ResponseEntity.ok(response);	
	}
}
