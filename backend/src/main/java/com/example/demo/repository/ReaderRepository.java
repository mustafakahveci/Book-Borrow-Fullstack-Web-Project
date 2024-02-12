package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
