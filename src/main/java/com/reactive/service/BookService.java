package com.reactive.service;

import com.reactive.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BookService {
//    Mono<Book> create(Book book);

    List<Book> getAll();

//    Flux<Book> getAllReactive();


//    Mono<Book> get(int bookId);

//    Mono<Book> update(Book book, int bookId);

//    Mono<Void> delete(int bookId);

//    Flux<Book> search(String query);
}
