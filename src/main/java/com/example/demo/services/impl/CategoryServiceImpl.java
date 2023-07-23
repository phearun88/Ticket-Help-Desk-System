package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.dto.CategoryDto;
import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.repository.dto.SubCategoryDto;
import com.example.demo.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDto insert(CategoryDto categoryDto) {
		boolean isInserted = categoryRepository.insert(categoryDto);
		if(isInserted)
			return categoryDto;
		else
			return null;
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public SubCategoryDto insert1(SubCategoryDto subCategoryDto) {
		boolean isInserted = categoryRepository.insert1(subCategoryDto);
		if(isInserted)
			return subCategoryDto;
		else
			return null;
	}

	@Override
	public List<SubCategoryDto> select(int cateId) {
		// TODO Auto-generated method stub
		return categoryRepository.find(cateId);
	}
	
	@Override
	public CategoryDto update(CategoryDto categoryDto) {
		boolean isUpdated =  categoryRepository.update(categoryDto); 
		 if (isUpdated) 
			 return categoryDto; 
		 else 
			 return categoryDto;
	}
	
	@Override
	public SubCategoryDto update1(SubCategoryDto subCategoryDto) {
		boolean isUpdated =  categoryRepository.update1(subCategoryDto); 
		 if (isUpdated) 
			 return subCategoryDto; 
		 else 
			 return subCategoryDto;
	}
}
