package com.graphqltesting.demo.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.dto.mapper.AuthorMapper;
import com.graphqltesting.demo.dto.mapper.BookMapper;
import com.graphqltesting.demo.dto.request.BookCreateDTO;
import com.graphqltesting.demo.dto.request.BookUpdateDTO;
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
        List<Author> authorsList = bookCreateDTO.authorIds().stream()
                .map(id -> AuthorMapper.toEntity(authorService.findById(id))).toList();
        Book book = BookMapper.toEntity(bookCreateDTO, authorsList);
        bookService.save(book);
        return BookMapper.toDTO(book);
    }

    public List<AuthorResponseDTO> findAuthorByBookId(Long id) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", id));
        return book.getAuthors().stream().map(AuthorMapper::toDTO).toList();
    }

    public Book updateBook(BookUpdateDTO bookUpdateDTO) {
        Book originalBook = bookService.findById(bookUpdateDTO.id())
                .orElseThrow(() -> new ResourceNotFoundException("Book", bookUpdateDTO.id()));
        if (!Objects.equals(bookUpdateDTO.title(), originalBook.getTitle())) {
            originalBook.setTitle(bookUpdateDTO.title());
        }
        if (!Objects.equals(bookUpdateDTO.publicationYear(), originalBook.getPublicationYear())) {
            originalBook.setPublicationYear(bookUpdateDTO.publicationYear());

        }
        List<Long> originalAuthorsIds = originalBook.getAuthors().stream().map(Author::getId).toList();
        List<Long> updateAuthorsIds = Objects.requireNonNullElse(bookUpdateDTO.authorIds(), List.of());
        if (!(originalAuthorsIds.containsAll(updateAuthorsIds) && updateAuthorsIds.containsAll(originalAuthorsIds))) {
            List<Author> updateAuthors = updateAuthorsIds.stream()
                    .map(authorService::findByIdEntity).collect(Collectors.toList());
            if (!updateAuthors.isEmpty()) {
                originalBook.setAuthors(updateAuthors);
            }
        }
        bookService.save(originalBook);
        return originalBook;

    }

}
