package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OfficerDto;
import com.example.demo.exc.GenericException;
import com.example.demo.model.Officer;
import com.example.demo.repository.OfficerRepository;
import com.example.demo.request.OfficerRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfficerService {
	
	private final OfficerRepository officerRepository;
	private final ModelMapper modelMapper;
	
	public OfficerDto getByOfficerId(Long id) {
		Officer officer = findOfficerById(id);
		return modelMapper.map(officer, OfficerDto.class);
	}
	
	public OfficerDto updateOfficer(Long id, OfficerRequest request) {
		Officer inDB = findOfficerById(id);
		inDB.setUsername(request.getUsername());
		inDB.setName(request.getName());
		inDB.setSurname(request.getName());
		inDB.setEmail(request.getEmail());
		inDB.setPassword(request.getEmail());
		inDB.setPhone(request.getPhone());
		inDB.setBirthDay(request.getBirthDay());
		inDB.setGender(request.getGender());
		officerRepository.save(inDB);
		return modelMapper.map(inDB, OfficerDto.class);
	}
	
	public void deleteOfficer(Long id) {
		Officer toDeleteOfficer = findOfficerById(id);
		officerRepository.delete(toDeleteOfficer);
	}
	
	public Officer findOfficerById(Long id) {
		return officerRepository.findById(id)
				.orElseThrow(() -> new GenericException("Officer not found", HttpStatus.NOT_FOUND));
	}
	
	
	
}
