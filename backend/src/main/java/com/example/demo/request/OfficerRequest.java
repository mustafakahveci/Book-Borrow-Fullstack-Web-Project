package com.example.demo.request;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.enums.Gender;
import com.example.demo.enums.Role;
import com.example.demo.model.Borrow;

import lombok.Getter;

@Getter
public class OfficerRequest {

    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private LocalDate birthDay;
    private Gender gender;

}
