package com.graphqltesting.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.models.Book;
import com.graphqltesting.demo.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // This could be better implemented if an error would be thrown and processed in
    // the parent method
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
