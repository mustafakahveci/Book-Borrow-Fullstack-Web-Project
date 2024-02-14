package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ImageFile;

public interface FileRepository extends JpaRepository<ImageFile, String> {

}
