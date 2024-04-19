package com.reactive.controller;

import com.reactive.model.Book;
import com.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/reactive")
    public Flux<Book> getAllReactive() {
        return bookService.getAllReactive();
    }



    @GetMapping("/{id}")
    public Mono<Book> get(@PathVariable("id") int bookId) {
        return bookService.get(bookId);
    }

    @PutMapping("/{id}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int id) {
        log.info(Thread.currentThread().getName());
        return bookService.update(book, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable int id) {
        return bookService.delete(id);
    }
}
