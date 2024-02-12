package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.CategoryDto;
import com.example.demo.request.CategoryRequest;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	private final BookService bookService;
    
    @GetMapping("/{id}/books")
    public List<BookDto> getBooksByCategoryId(@PathVariable Long id){
		return bookService.getBooksByCategoryId(id);
    }
    
    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryRequest request) {
    	return categoryService.createCategory(request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	categoryService.deleteCategory(id);
    }
    
    @GetMapping("/{id}")
    public CategoryDto getByCategoryId(@PathVariable Long id) {
    	return categoryService.getByCategoryId(id);
    }
	
}
