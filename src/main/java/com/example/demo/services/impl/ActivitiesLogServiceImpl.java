package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ActivitiesLogRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.repository.dto.ActivitiesLogDto;
import com.example.demo.repository.dto.UsersDetailDto;
import com.example.demo.services.ActivitiesLogService;

@Service
public class ActivitiesLogServiceImpl implements ActivitiesLogService{

	
	
	private ActivitiesLogRepository activitiesLogRepository;
	
	@Autowired
	public void setActivitiesLogRepository(ActivitiesLogRepository activitiesLogRepository) {
		this.activitiesLogRepository = activitiesLogRepository;
	}
	
	
	@Override
	public ActivitiesLogDto insert(ActivitiesLogDto activitiesLogDto) {
		boolean isInserted = activitiesLogRepository.insert(activitiesLogDto);
		if(isInserted)
			return activitiesLogDto;
		else
			return null;
	}

	@Override
	public List<ActivitiesLogDto> findAll() {
		// TODO Auto-generated method stub
		return activitiesLogRepository.findAll();
	}
	

}
