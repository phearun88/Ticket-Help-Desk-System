package com.example.demo.services;

import java.util.List;

import com.example.demo.repository.dto.UsersDetailDto;
import com.example.demo.repository.dto.UsersDto;

public interface UsersService {

	UsersDto insert(UsersDto usersDto);
	
	List<UsersDto> selectById(String username);
	
	UsersDetailDto insert1(UsersDetailDto usersDetailDto);
	
	List<UsersDetailDto> findAll();
	
	List<UsersDetailDto> select1(String user_code);
	
	UsersDetailDto update(UsersDetailDto usersDetailDto);
}
