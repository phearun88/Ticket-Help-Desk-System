package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.dto.ActivitiesLogDto;

@Repository
public interface ActivitiesLogRepository {

	
	@Insert("INSERT INTO activities_log (user_code, username , authentication, created_date,updated_date) "+
			 "VALUES (#{user_code}, #{username}, #{authentication},  TO_CHAR(NOW(),'YYYYMMDDHH24MISS'), TO_CHAR(NOW(),'YYYYMMDDHH24MISS'))")
	boolean insert(ActivitiesLogDto activitiesLogDto);
	
	
	@Select("SELECT user_code, username, authentication, created_date FROM activities_log")
	List<ActivitiesLogDto> findAll();

}
