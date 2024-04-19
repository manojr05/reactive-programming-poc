package com.reactive.repository;

import com.reactive.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveBookRepository extends ReactiveCrudRepository<Book, Integer> {
}
