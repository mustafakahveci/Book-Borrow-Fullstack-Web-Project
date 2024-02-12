package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OfficerDto;
import com.example.demo.request.OfficerRequest;
import com.example.demo.service.OfficerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/officer")
@RequiredArgsConstructor
public class OfficerController {
	
	private final OfficerService officerService;
	
	@GetMapping("/{id}")
	public OfficerDto getByOfficerId(@PathVariable Long id) {
		return officerService.getByOfficerId(id);
	}
	
	@PutMapping("/{id}")
	public OfficerDto updateOfficer(@PathVariable Long id,@RequestBody OfficerRequest request) {
		return officerService.updateOfficer(id,request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOfficer(@PathVariable Long id) {
		officerService.deleteOfficer(id);
	}
	
}
