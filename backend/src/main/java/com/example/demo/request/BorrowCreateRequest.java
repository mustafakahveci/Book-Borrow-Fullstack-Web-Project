package com.example.demo.request;

import lombok.Getter;

@Getter
public class BorrowCreateRequest {

	private Long readerId;
	private Long bookId;
	private int day;

}
