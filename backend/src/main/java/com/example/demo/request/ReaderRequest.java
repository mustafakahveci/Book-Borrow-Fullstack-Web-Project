package com.example.demo.request;

import java.time.LocalDate;

import com.example.demo.enums.Gender;

import lombok.Getter;

@Getter
public class ReaderRequest {
	
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private LocalDate birthDay;
    private Gender gender;
	
}
