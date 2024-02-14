package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name = "reader")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Reader extends User {
	
	@ElementCollection
	private final List<Book> currentlyBorrow = new ArrayList<Book>();
	//	şuan ödünç aldıkları
	
	@ElementCollection
	private final List<Book> borrowed = new ArrayList<Book>();
	// daha önce ödünç alınanlar
	
	@ElementCollection
	private final List<Book> willBorrow = new ArrayList<Book>();
	// ödünç almayı planladıkları
	
	@OneToMany(mappedBy = "reader",fetch = FetchType.LAZY)
	@JsonIgnore   //reader eklediğinde talep eklemek gerekmemesi için
	private List<Borrow> borrow;
	//oluşturduğu talepler
}
