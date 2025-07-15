package com.graphqltesting.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.dto.InsertBook;
import com.graphqltesting.demo.exceptions.ResourceNotFoundException;
import com.graphqltesting.demo.models.Author;
import com.graphqltesting.demo.models.Book;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final AuthorService authorService;
    private final BookService bookService;

    
    public Book saveBook(InsertBook insertBook) {
        List<Author> authorsList = insertBook.authorIds().stream().map(id -> authorService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", id))).toList();
        Book book = new Book(insertBook.title(), insertBook.publicationYear(), authorsList);
        bookService.save(book);
        return book;
    }


    public List<Author> findAuthorByBookId(Long id) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", id));
            return book.getAuthors();
    }

}
