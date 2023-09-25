package com.example.controller;

import com.example.dto.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/list")
    public List<Book> listBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books/save")
    public Book saveBooks(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

}
