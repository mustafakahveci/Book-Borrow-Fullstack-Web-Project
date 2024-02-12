package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDto;
import com.example.demo.request.BookRequest;
import com.example.demo.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@GetMapping
	public List<BookDto> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public BookDto getByBookId(@PathVariable Long id) {
		return bookService.getByBookId(id);
	}
	
	@PostMapping
	public BookDto createBook(@RequestBody BookRequest request) {
		return bookService.createBook(request);
	}
	
	@PutMapping("/{id}")
	public BookDto updateBook(@PathVariable Long id,@RequestBody BookRequest request) {
		return bookService.updateBook(id,request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}
	
	
}
