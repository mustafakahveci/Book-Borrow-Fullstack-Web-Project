package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "files")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageFile {
	@Id
    private String id;
    private String type;
    private String filePath;
}
