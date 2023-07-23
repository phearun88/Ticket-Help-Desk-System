package com.example.demo.services;

import java.util.List;

import com.example.demo.repository.dto.ActivitiesLogDto;

public interface ActivitiesLogService {
	
	ActivitiesLogDto insert(ActivitiesLogDto activitiesLogDto);
	
	List<ActivitiesLogDto> findAll(); 

}
