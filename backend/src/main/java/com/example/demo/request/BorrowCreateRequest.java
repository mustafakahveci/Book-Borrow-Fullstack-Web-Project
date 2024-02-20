package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowCreateRequest {

	private Long readerId;
	private Long bookId;
	private int day;

}
