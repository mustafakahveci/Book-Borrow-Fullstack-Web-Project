package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Book> currentlyBorrow;
	//	şuan ödünç aldıkları
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Book> borrowed;
	// daha önce ödünç alınanlar
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Book> willBorrow;
	// ödünç almayı planladıkları
	
	@OneToMany(mappedBy = "reader",fetch = FetchType.LAZY)
	@JsonIgnore   //reader eklediğinde talep eklemek gerekmemesi için
	private List<Borrow> borrow;
	//oluşturduğu talepler
}
