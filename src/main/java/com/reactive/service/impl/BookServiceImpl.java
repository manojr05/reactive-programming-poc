package com.reactive.service.impl;

import com.reactive.model.Book;
import com.reactive.repository.BookRepository;
import com.reactive.repository.ReactiveBookRepository;
import com.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final ReactiveBookRepository reactiveBookRepository;
    private final BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        log.info(Thread.currentThread().getName());
        return reactiveBookRepository.save(book).doOnNext(data-> log.info(Thread.currentThread().getName()));
    }

    @Override
    public Flux<Book> getAllReactive() {
        return reactiveBookRepository.findAll();
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
        return reactiveBookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
       return reactiveBookRepository.findById(bookId).flatMap(update->{
           update.setName(book.getName());
            update.setAuthor(book.getAuthor());
            return reactiveBookRepository.save(update).log();
        });
    }

    @Override
    public Mono<Void> delete(int bookId) {
        return reactiveBookRepository.deleteById(bookId);
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }
}
