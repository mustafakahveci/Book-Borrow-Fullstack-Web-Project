package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
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
@Table(name = "officer")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Officer extends User {

	@OneToMany(mappedBy = "officer")
	@JsonIgnore   //officer eklediğinde talep eklemek gerekmemesi için
	private List<Borrow> borrow;
	//onayladığı talepler
}
