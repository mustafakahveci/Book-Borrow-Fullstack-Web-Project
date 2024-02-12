package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDto;
import com.example.demo.exc.GenericException;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.request.BookRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	
	private final BookRepository bookRepository;
	private final CategoryService categoryService;
	private final ModelMapper modelMapper;
	
	public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }
	
	public BookDto getByBookId(Long id) {
		Book book = findBookById(id);
		return modelMapper.map(book, BookDto.class);
	}

	public BookDto createBook(BookRequest request) {
	    Category category = null;                                 /* bu kısımda düzeltme yapılabilir doğrusu bu değildir */
	    Long categoryId = request.getCategoryId();
	    if (categoryId != null) {
	        category = categoryService.findCategoryById(categoryId);
	    }
		Book book = Book.builder()
				.name(request.getName())
				.summary(request.getSummary())
				.authorName(request.getAuthorName())
				.publisher(request.getPublisher())
				.language(request.getLanguage())
				.imageUrl(request.getImageUrl())
				.stock(request.getStock())
				.category(category)
				.build();
		bookRepository.save(book);
		return modelMapper.map(book, BookDto.class);
	}
	
	public BookDto updateBook(Long id,BookRequest request) {
		Book inDB = findBookById(id);
		inDB.setName(request.getName());
		inDB.setSummary(request.getSummary());
		inDB.setAuthorName(request.getAuthorName());
		inDB.setPublisher(request.getPublisher());
		inDB.setLanguage(request.getLanguage());
		inDB.setImageUrl(request.getImageUrl());
		inDB.setStock(request.getStock());
		if(request.getCategoryId() != null) {                                                /* bu kısımda düzeltme yapılabilir doğrusu bu değildir */
			Category category = categoryService.findCategoryById(request.getCategoryId());
			inDB.setCategory(category);
		}
		else if(request.getCategoryId() == null) {
			Category category = null;
			inDB.setCategory(category);
		}
		bookRepository.save(inDB);
		return modelMapper.map(inDB,BookDto.class);
	}
	
	public void deleteBook(Long id) {
		Book toDeleteBook = findBookById(id);
		bookRepository.delete(toDeleteBook);
	}
	
	public List<BookDto> getBooksByCategoryId(Long id){
		Category inDB = categoryService.findCategoryById(id);
		return bookRepository.findBooksByCategoryId(inDB.getId()).stream()
				.map(x -> modelMapper.map(x,BookDto.class))
				.collect(Collectors.toList());
	}
	
	public Book findBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new GenericException("Book not found.", HttpStatus.NOT_FOUND));
	}
}
