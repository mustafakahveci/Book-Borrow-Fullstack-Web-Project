package com.example.demo.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class BookDto {

	private Long id;
	private String name;
	private String summary;
	private String authorName;
	private String publisher;
	private String language;
	private String imageId;
	private Long stock;
	private String categoryId;
}
