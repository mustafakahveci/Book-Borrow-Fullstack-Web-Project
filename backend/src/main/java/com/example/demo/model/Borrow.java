package com.example.demo.model;

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
@Table(name = "borrow")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reader_id")
	private Reader reader;
	// talep oluşturan reader
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "officer_id")
	private Officer officer;
	// talebi onaylayan memur
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	// talep edilen kitap
	
	private int day;
	// talep süresi	
	
	private boolean status;
}
