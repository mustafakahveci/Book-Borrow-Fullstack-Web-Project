package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.enums.Gender;
import com.example.demo.enums.Role;
import com.example.demo.model.Book;
import com.example.demo.model.Borrow;

import lombok.Data;

@Data
public class ReaderDto {

    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private LocalDate birthDay;
    private Role role;
    private Gender gender;

	private List<Book> currentlyBorrow;
	private List<Book> borrowed;
	private List<Book> willBorrow;
	private List<Borrow> borrow;

}
