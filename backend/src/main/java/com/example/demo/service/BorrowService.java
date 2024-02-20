package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BorrowDto;
import com.example.demo.exc.GenericException;
import com.example.demo.model.Book;
import com.example.demo.model.Borrow;
import com.example.demo.model.Reader;
import com.example.demo.model.Officer;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowRepository;
import com.example.demo.request.BorrowCreateRequest;
import com.example.demo.request.BorrowUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowService {

	private final BorrowRepository borrowRepository;
	private final ModelMapper modelMapper;
	private final ReaderService readerService;
	private final BookService bookService;
	private final OfficerService officerService;
	private final BookRepository bookRepository;
	
	public BorrowDto createBorrow(BorrowCreateRequest request) {
		if(request.getDay() == 0) {
			request.setDay(14);
		}
		Reader reader = readerService.findReaderById(request.getReaderId());
		Book book = bookService.findBookById(request.getBookId());
		Borrow borrow = Borrow.builder()
				.reader(reader)
				.book(book)
				.day(request.getDay())
				.officer(null)
				.status(false)
				.build();
		borrowRepository.save(borrow);
		return modelMapper.map(borrow, BorrowDto.class);
	}

	public BorrowDto updateBorrow(Long id, BorrowUpdateRequest request) {
		Borrow inDB = findBorrowById(id);
		if (inDB.isStatus() == true) {
	        throw new IllegalStateException("Talep zaten onaylı.");
	    }else {
	    	inDB.setStatus(true);
			Officer officer = officerService.findOfficerById(request.getOfficerId());
			inDB.setOfficer(officer);
			borrowRepository.save(inDB);
			
			Book book = inDB.getBook();
			book.setStock(book.getStock() - 1);
			bookRepository.save(book);
			
			return modelMapper.map(inDB,BorrowDto.class);
	    }
	}
	
	public Borrow findBorrowById(Long id) {
		return borrowRepository.findById(id)
				.orElseThrow(() -> new GenericException("Borrow not found.", HttpStatus.NOT_FOUND));
	}

	public List<BorrowDto> getAllBooks() {
		return borrowRepository.findAll().stream()
				.map(borrow ->{
					BorrowDto borrowDto = modelMapper.map(borrow, BorrowDto.class);
					borrowDto.setReaderId(borrow.getReader().getName());
					borrowDto.setBookId(borrow.getBook().getName());
					return borrowDto;
				})
				.collect(Collectors.toList());
	}

	public BorrowDto getByBorrowId(Long id) {
		Borrow borrow = findBorrowById(id);
		return modelMapper.map(borrow, BorrowDto.class);
	}

	public void deleteBorrow(Long id) {
		Borrow toDeleteBorrow = findBorrowById(id);
		borrowRepository.delete(toDeleteBorrow);
	}
	
}
