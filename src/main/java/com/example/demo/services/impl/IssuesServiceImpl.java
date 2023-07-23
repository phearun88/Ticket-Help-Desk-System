package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IssuesRepository;
import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.services.IssuesService;

@Service
public class IssuesServiceImpl implements IssuesService {

private IssuesRepository issuesRepository;
	
	@Autowired
	public void setIssuesRepository(IssuesRepository issuesRepository) {
		this.issuesRepository = issuesRepository;
	}
	
	@Override
	public IssuesDto insert(IssuesDto issuesDto) {
		// TODO Auto-generated method stub
		boolean isInserted = issuesRepository.insert(issuesDto);
		if(isInserted)
			return issuesDto;
		else
			return null;
	}

	@Override
	public List<IssuesDto> findAll() {
		// TODO Auto-generated method stub
		return issuesRepository.findAll();
	}

	@Override
	public IssuesDto update(IssuesDto issuesDto) {
		boolean isUpdated =  issuesRepository.update(issuesDto); 
		 if (isUpdated) 
			 return issuesDto; 
		 else 
			 return issuesDto;
	}

	@Override
	public List<IssuesDto> select(int issesId) {
		// TODO Auto-generated method stub
		return issuesRepository.select(issesId);
	}

	@Override
	public List<IssuesDto> select1(String user_code) {
		// TODO Auto-generated method stub
		return issuesRepository.select1(user_code);
	}

	@Override
	public List<IssuesDto> select2(String iss_status) {
		// TODO Auto-generated method stub
		return issuesRepository.select2(iss_status);
	}

	
	
}
