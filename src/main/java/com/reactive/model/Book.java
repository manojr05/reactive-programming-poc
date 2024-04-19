package com.reactive.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @Column("bookId")
    private Integer bookId;
    private String name;
    private String author;
}
