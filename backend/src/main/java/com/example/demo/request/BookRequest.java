package com.example.demo.request;

import lombok.Getter;

@Getter
public class BookRequest {

	private String name;
	private String summary;
	private String authorName;
	private String publisher;
	private String language;
	private String imageUrl;
	private Long stock;
	private Long categoryId;

}
