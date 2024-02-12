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

import com.example.demo.dto.BorrowDto;
import com.example.demo.request.BorrowCreateRequest;
import com.example.demo.request.BorrowUpdateRequest;
import com.example.demo.service.BorrowService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
public class BorrowController {

	private final BorrowService borrowService;
	
	@PostMapping
	public BorrowDto createBorrow(@RequestBody BorrowCreateRequest request) {
		return borrowService.createBorrow(request);
	}
	
	@PutMapping("/{id}")
	public BorrowDto updateBorrow(@PathVariable Long id, @RequestBody BorrowUpdateRequest request) {
		return borrowService.updateBorrow(id,request);
	}
	
	@GetMapping
	public List<BorrowDto> getAllBorrows(){
		return borrowService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public BorrowDto getByBorrowId(@PathVariable Long id) {
		return borrowService.getByBorrowId(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBorrow(@PathVariable Long id) {
		borrowService.deleteBorrow(id);
	}
	
	
}
