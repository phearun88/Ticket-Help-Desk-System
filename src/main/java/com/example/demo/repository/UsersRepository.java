package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.dto.UsersDetailDto;
import com.example.demo.repository.dto.UsersDto;

@Repository
public interface UsersRepository {

	@Insert("INSERT INTO users (user_code, username , password, authentication) "+
			 "VALUES (#{user_code}, #{username}, #{password}, #{authentication})")
	boolean insert(UsersDto usersDto);

	@Select("SELECT user_code,username,authentication FROM users WHERE username = #{username}")
	List<UsersDto> selectById(String username);

	@Insert("INSERT INTO users_detail (user_code, user_nm_kh , user_nm_en, user_gender, user_dob, user_id_cd, user_position, dept_nm, usr_old_add, usr_new_add, usr_tel, usr_email, created_date, updated_date) "+
			 "VALUES (#{user_code}, #{user_nm_kh}, #{user_nm_en}, #{user_gender}, #{user_dob}, #{user_id_cd}, #{user_position}, #{dept_nm}, #{usr_old_add}, #{usr_new_add}, #{usr_tel}, #{usr_email}, TO_CHAR(NOW(),'YYYYMMDDHH24MISS'), TO_CHAR(NOW(),'YYYYMMDDHH24MISS'))")
	boolean insert1(UsersDetailDto usersDetailDto);

	@Select("SELECT user_code, user_nm_kh, user_nm_en, user_gender,  user_dob, user_id_cd, user_position, dept_nm, usr_old_add, usr_new_add, usr_tel, usr_email  FROM users_detail")
	List<UsersDetailDto> findAll();

	
	@Select("SELECT user_code, user_nm_kh, user_nm_en, user_gender,  user_dob, user_id_cd, user_position, dept_nm, usr_old_add, usr_new_add, usr_tel, usr_email  FROM users_detail WHERE user_code = #{user_code}")
	List<UsersDetailDto> select1(String user_code);

	@Update("UPDATE users_detail SET user_nm_kh=#{user_nm_kh},user_nm_en=#{user_nm_en},user_gender=#{user_gender},user_dob=#{user_dob}, user_id_cd=#{user_id_cd}, user_position=#{user_position}, dept_nm=#{dept_nm}, usr_old_add=#{usr_old_add}, usr_new_add=#{usr_new_add}, usr_tel=#{usr_tel}, usr_email=#{usr_email}, updated_date=TO_CHAR(NOW(),'YYYYMMDDHH24MISS')  where user_code=#{user_code}")
	boolean update(UsersDetailDto usersDetailDto);

}


