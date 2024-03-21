package com.reactive;

import com.reactive.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {
}
