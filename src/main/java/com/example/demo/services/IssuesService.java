package com.example.demo.services;

import java.util.List;

import com.example.demo.repository.dto.IssuesDto;

public interface IssuesService {
	
	IssuesDto insert(IssuesDto issuesDto);
	
	List<IssuesDto> findAll();
	
	IssuesDto update(IssuesDto issuesDto);
	
	List<IssuesDto> select(int issesId);
	
	List<IssuesDto> select1(String user_code);
	
	List<IssuesDto> select2(String iss_status);
	

}
