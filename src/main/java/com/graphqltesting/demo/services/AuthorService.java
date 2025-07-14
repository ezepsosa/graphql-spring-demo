package com.graphqltesting.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.models.Author;
import com.graphqltesting.demo.models.Book;
import com.graphqltesting.demo.repositories.AuthorRepository;
import com.graphqltesting.demo.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookService bookService;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findByBookId(Long id) {
        Book book = bookService.findById(id);
        if(book != null){
            return book.getAuthors();
        }
        return Arrays.asList();
    }

}
