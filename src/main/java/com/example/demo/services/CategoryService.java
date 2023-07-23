package com.example.demo.services;


import java.util.List;

import com.example.demo.repository.dto.CategoryDto;
import com.example.demo.repository.dto.SubCategoryDto;

public interface CategoryService {

	CategoryDto insert(CategoryDto categoryDto);
	
	SubCategoryDto insert1(SubCategoryDto subCategoryDto);
	
	List<CategoryDto> findAll();
	
	List<SubCategoryDto> select(int cateId);

	CategoryDto update(CategoryDto categoryDto);
	SubCategoryDto update1(SubCategoryDto subCategoryDto);
}
