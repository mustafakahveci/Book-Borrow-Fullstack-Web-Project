package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.exc.GenericException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.request.CategoryRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;
	
	public CategoryDto getByCategoryId(Long categoryId) {
		Category category = findCategoryById(categoryId);
		return modelMapper.map(category, CategoryDto.class);
	}

	public CategoryDto createCategory(CategoryRequest request) {
		Category category = Category.builder()
				.name(request.getName())
				.build();
		categoryRepository.save(category);
		return modelMapper.map(category,CategoryDto.class);
	}

	public void deleteCategory(Long id) {
		Category toDeleteCategory = findCategoryById(id);
		categoryRepository.delete(toDeleteCategory);	
	}

	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new GenericException("Category not found.", HttpStatus.NOT_FOUND));
	}
	
}
