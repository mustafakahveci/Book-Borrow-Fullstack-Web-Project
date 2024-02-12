package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReaderDto;
import com.example.demo.exc.GenericException;
import com.example.demo.model.Reader;
import com.example.demo.repository.ReaderRepository;
import com.example.demo.request.ReaderRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReaderService {
	
	private final ReaderRepository readerRepository;
	private final ModelMapper modelMapper;
	
	public ReaderDto getByReaderId(Long id) {
		Reader reader = findReaderById(id);
		return modelMapper.map(reader, ReaderDto.class);
	}

	public ReaderDto updateReader(Long id, ReaderRequest request) {
		Reader inDB = findReaderById(id);
		inDB.setUsername(request.getUsername());
		inDB.setName(request.getName());
		inDB.setSurname(request.getSurname());
		inDB.setEmail(request.getEmail());
		inDB.setPassword(request.getPassword());
		inDB.setPhone(request.getPhone());
		inDB.setBirthDay(request.getBirthDay());
		inDB.setGender(request.getGender());
		readerRepository.save(inDB);
		return modelMapper.map(inDB, ReaderDto.class);
	}

	public void deleteReader(Long id) {
		Reader toDeleteReader = findReaderById(id);
		readerRepository.delete(toDeleteReader);
	}
	
	public Reader findReaderById(Long id) {
		return readerRepository.findById(id)
				.orElseThrow(() -> new GenericException("Reader not found.", HttpStatus.NOT_FOUND)); 
	}

}
