package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.dto.IssuesDto;

@Repository
public interface IssuesRepository {

	
	@Insert("INSERT INTO tbl_issues (iss_nm, iss_cate_id , iss_subcate_id, iss_desc, iss_status, iss_priority, iss_assignee, user_code, iss_done, started_date, due_date, iss_yn, created_date, updated_date) "+
			 "VALUES (#{iss_nm}, #{iss_cate_id}, #{iss_subcate_id}, #{iss_desc}, #{iss_status}, #{iss_priority}, #{iss_assignee}, #{user_code}, #{iss_done}, #{started_date}, #{due_date}, #{iss_yn}, TO_CHAR(NOW(),'YYYYMMDDHH24MISS'), TO_CHAR(NOW(),'YYYYMMDDHH24MISS'))")
	boolean insert(IssuesDto issuesDto);

	
	@Select("SELECT a.iss_id, a.iss_nm, a.iss_cate_id, a.iss_subcate_id,  a.iss_desc, a.iss_status, a.iss_priority, a.iss_assignee, a.user_code, a.iss_done, a.started_date, a.due_date, a.updated_date, a.iss_yn, b.cate_id, b.category_nm, c.sub_cate_id, c.sub_category_nm , d.user_nm_kh  FROM tbl_issues as a JOIN tbl_category as b on a.iss_cate_id = b.cate_id JOIN tbl_subcategory as c on a.iss_subcate_id = c.sub_cate_id JOIN users_detail as d on a.user_code = d.user_code  WHERE a.iss_yn = '1'")
	@Results(value={
			  @Result(property="categoryDto.cate_id", column="cate_id"),
			  @Result(property="categoryDto.category_nm", column="category_nm"),
			  @Result(property="subCategoryDto.sub_cate_id", column="sub_cate_id"),
			  @Result(property="subCategoryDto.sub_category_nm", column="sub_category_nm"),
			  @Result(property="usersDetailDto.user_nm_kh", column="user_nm_kh"),
	})
	List<IssuesDto> findAll();

	
	//@Update("UPDATE tbl_issues SET iss_status=#{iss_status},iss_assignee=#{iss_assignee},iss_done=#{iss_done},started_date=#{started_date},due_date=#{due_date}, updated_date=TO_CHAR(NOW(),'YYYYMMDDHH24MISS')  where iss_id=#{iss_id}")
	//boolean update(IssuesDto issuesDto);
	
	@Update("UPDATE tbl_issues SET iss_nm=#{iss_nm},iss_cate_id=#{iss_cate_id},iss_subcate_id=#{iss_subcate_id},iss_desc=#{iss_desc},iss_status=#{iss_status}, iss_priority=#{iss_priority}, iss_assignee=#{iss_assignee}, iss_done=#{iss_done}, iss_yn=#{iss_yn}, user_code=#{user_code}, started_date=#{started_date}, due_date=#{due_date}, updated_date=TO_CHAR(NOW(),'YYYYMMDDHH24MISS')  where iss_id=#{iss_id}")
	boolean update(IssuesDto issuesDto);


	@Select("SELECT * FROM tbl_issues WHERE iss_id = #{iss_id}")
	List<IssuesDto> select(int issesId);

	@Select("SELECT a.iss_id, a.iss_nm, a.iss_cate_id, a.iss_subcate_id,  a.iss_desc, a.iss_status, a.iss_priority, a.iss_assignee, a.user_code, a.iss_done, a.started_date, a.due_date, a.updated_date, a.iss_yn, b.cate_id, b.category_nm, c.sub_cate_id, c.sub_category_nm , d.user_nm_kh FROM tbl_issues as a JOIN tbl_category as b on a.iss_cate_id = b.cate_id JOIN tbl_subcategory as c on a.iss_subcate_id = c.sub_cate_id JOIN users_detail as d on a.user_code = d.user_code WHERE a.user_code = #{user_code}")
	@Results(value={
			  @Result(property="categoryDto.cate_id", column="cate_id"),
			  @Result(property="categoryDto.category_nm", column="category_nm"),
			  @Result(property="subCategoryDto.sub_cate_id", column="sub_cate_id"),
			  @Result(property="subCategoryDto.sub_category_nm", column="sub_category_nm"),
			  @Result(property="usersDetailDto.user_nm_kh", column="user_nm_kh"),
	})
	List<IssuesDto> select1(String user_code);

	@Select("SELECT a.iss_id, a.iss_nm, a.iss_cate_id, a.iss_subcate_id,  a.iss_desc, a.iss_status, a.iss_priority, a.iss_assignee, a.user_code, a.iss_done, a.started_date, a.due_date, a.updated_date, a.iss_yn, b.cate_id, b.category_nm, c.sub_cate_id, c.sub_category_nm , d.user_nm_kh FROM tbl_issues as a JOIN tbl_category as b on a.iss_cate_id = b.cate_id JOIN tbl_subcategory as c on a.iss_subcate_id = c.sub_cate_id JOIN users_detail as d on a.user_code = d.user_code WHERE a.iss_status = #{iss_status} and a.iss_yn = '1'")
	@Results(value={
			  @Result(property="categoryDto.cate_id", column="cate_id"),
			  @Result(property="categoryDto.category_nm", column="category_nm"),
			  @Result(property="subCategoryDto.sub_cate_id", column="sub_cate_id"),
			  @Result(property="subCategoryDto.sub_category_nm", column="sub_category_nm"),
			  @Result(property="usersDetailDto.user_nm_kh", column="user_nm_kh"),
	})
	List<IssuesDto> select2(String iss_status);



}



