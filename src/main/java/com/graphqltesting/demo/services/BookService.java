package com.graphqltesting.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.dto.InsertBook;
import com.graphqltesting.demo.exceptions.ResourceNotFoundException;
import com.graphqltesting.demo.models.Author;
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
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void save(Book book){
        bookRepository.save(book);
    }
}
