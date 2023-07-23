package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.dto.CategoryDto;
import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.repository.dto.SubCategoryDto;

@Repository
public interface CategoryRepository {
	
	@Insert("INSERT INTO tbl_category (category_nm, category_st , user_id, created_date ,updated_date) "+
			 "VALUES (#{category_nm}, #{category_st}, #{user_id}, TO_CHAR(NOW(),'YYYYMMDDHH24MISS'), TO_CHAR(NOW(),'YYYYMMDDHH24MISS'))")
	boolean insert(CategoryDto categoryDto);

	@Select("SELECT cate_id, category_nm, category_st, user_id,  created_date, updated_date  FROM tbl_category")
	List<CategoryDto> findAll();

	
	@Insert("INSERT INTO tbl_subcategory (sub_category_nm, sub_category_st , cate_id , user_id, created_date ,updated_date) "+
			 "VALUES (#{sub_category_nm}, #{sub_category_st}, #{cate_id}, #{user_id}, TO_CHAR(NOW(),'YYYYMMDDHH24MISS'), TO_CHAR(NOW(),'YYYYMMDDHH24MISS'))")
	boolean insert1(SubCategoryDto subCategoryDto);

	@Select("SELECT sub_cate_id, sub_category_nm, sub_category_st, cate_id, user_id  FROM tbl_subcategory WHERE cate_id = #{cate_id}")
	List<SubCategoryDto> find(int cateId);

	@Update("UPDATE tbl_category SET category_st=#{category_st}, updated_date=TO_CHAR(NOW(),'YYYYMMDDHH24MISS')  where cate_id=#{cate_id}")
	boolean update(CategoryDto categoryDto);

	@Update("UPDATE tbl_subcategory SET sub_category_st=#{sub_category_st}, updated_date=TO_CHAR(NOW(),'YYYYMMDDHH24MISS')  where sub_cate_id=#{sub_cate_id}")
	boolean update1(SubCategoryDto subCategoryDto);


}
