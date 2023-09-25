package com.example.service;

import com.example.dto.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList = new ArrayList<>();

    public List<Book> getAllBooks() {
        loadDataIfEmpty();
        return bookList;
    }

    public Book saveBook(Book book) {
        bookList.add(book);
        return book;
    }

    private void loadDataIfEmpty() {
        if( bookList.isEmpty() ) {
            bookList.add(new Book("Book 1", "123"));
        }
    }

}
