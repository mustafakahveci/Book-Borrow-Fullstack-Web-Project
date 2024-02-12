package com.example.demo.dto;

import lombok.Data;

@Data
public class BorrowDto {

	private Long id;
	private Long readerId;
	private Long officerId;
	private Long bookId;
	private int day;
	private boolean status;
}
