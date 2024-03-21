package com.reactive.service.impl;

import com.reactive.BookRepository;
import com.reactive.model.Book;
import com.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
       return bookRepository.findById(bookId).flatMap(update->{
            update.setName(book.getName());
            update.setAuthor(book.getAuthor());
            return bookRepository.save(update);
        });
    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepository.deleteById(bookId);
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }
}
