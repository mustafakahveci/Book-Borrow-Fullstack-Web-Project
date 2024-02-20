package com.example.demo.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class BorrowDto {

	private Long id;
	private String readerId;
	private Long officerId;
	private String bookId;
	private int day;
	private boolean status;
}
