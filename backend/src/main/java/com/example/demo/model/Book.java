package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "book")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String summary;
	private String authorName;
	private String publisher;
	private String language;
	//private String imageUrl;
	private Long stock;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@Nullable
	private Category category;
	
	@OneToOne(mappedBy = "book",fetch = FetchType.LAZY)
	@JsonIgnore
	private Borrow borrow;
	
	private String imageId;
		
}
