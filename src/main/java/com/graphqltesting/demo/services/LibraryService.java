package com.graphqltesting.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.dto.mapper.AuthorMapper;
import com.graphqltesting.demo.dto.mapper.BookMapper;
import com.graphqltesting.demo.dto.request.BookCreateDTO;
import com.graphqltesting.demo.dto.response.AuthorResponseDTO;
import com.graphqltesting.demo.dto.response.BookResponseDTO;
import com.graphqltesting.demo.exceptions.ResourceNotFoundException;
import com.graphqltesting.demo.models.Author;
import com.graphqltesting.demo.models.Book;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final AuthorService authorService;
    private final BookService bookService;

    
    public BookResponseDTO saveBook(BookCreateDTO bookCreateDTO) {
        List<Author> authorsList = bookCreateDTO.authorIds().stream().map(id -> AuthorMapper.toEntity(authorService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", id)))).toList();
        Book book = BookMapper.toEntity(bookCreateDTO, authorsList);
        bookService.save(book);
        return BookMapper.toDTO(book);
    }


    public List<AuthorResponseDTO> findAuthorByBookId(Long id) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", id));
            return book.getAuthors().stream().map(AuthorMapper::toDTO).toList();
    }


/*
 *     public Book updateBook(UpdateBook updateBook) {
        Book book = bookService.findById(insertBook)
    }
 */

}
