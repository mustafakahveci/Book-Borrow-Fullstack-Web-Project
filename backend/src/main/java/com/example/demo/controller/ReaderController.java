package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReaderDto;
import com.example.demo.request.ReaderRequest;
import com.example.demo.service.ReaderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reader")
@RequiredArgsConstructor
public class ReaderController {

	private final ReaderService readerService;
	
	@GetMapping("/{id}")
	public ReaderDto getByReaderId(@PathVariable Long id) {
		return readerService.getByReaderId(id);
	}
	
	@PutMapping("/{id}")
	public ReaderDto updateReader(@PathVariable Long id,@RequestBody ReaderRequest request) {
		return readerService.updateReader(id,request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReader(@PathVariable Long id) {
		readerService.deleteReader(id);
	}
	
}
