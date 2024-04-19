package com.reactive.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    private Integer bookId;
    private String name;
    private String author;
}
