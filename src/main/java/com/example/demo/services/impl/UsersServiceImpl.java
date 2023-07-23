package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UsersRepository;
import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.repository.dto.UsersDetailDto;
import com.example.demo.repository.dto.UsersDto;
import com.example.demo.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	private UsersRepository usersRepository;
	
	@Autowired
	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@Override
	public UsersDto insert(UsersDto usersDto) {
		boolean isInserted = usersRepository.insert(usersDto);
		if(isInserted)
			return usersDto;
		else
			return null;
	}

	@Override
	public List<UsersDto> selectById(String username) {
		// TODO Auto-generated method stub
		return usersRepository.selectById(username);
	}

	@Override
	public UsersDetailDto insert1(UsersDetailDto usersDetailDto) {
		boolean isInserted = usersRepository.insert1(usersDetailDto);
		if(isInserted)
			return usersDetailDto;
		else
			return null;
	}

	@Override
	public List<UsersDetailDto> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}
 
	@Override
	public List<UsersDetailDto> select1(String user_code) {
		// TODO Auto-generated method stub
		return usersRepository.select1(user_code);
	}

	
	@Override
	public UsersDetailDto update(UsersDetailDto usersDetailDto) {
		boolean isUpdated =  usersRepository.update(usersDetailDto); 
		 if (isUpdated) 
			 return usersDetailDto; 
		 else 
			 return usersDetailDto;
	}
	
}
