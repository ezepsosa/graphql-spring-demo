package com.graphqltesting.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.exceptions.ResourceNotFoundException;
import com.graphqltesting.demo.models.Book;
import com.graphqltesting.demo.repositories.BookRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // This could be better implemented if an error would be thrown and processed in
    // the parent method
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public Boolean delete(Long id) {
        Book bookToDelete = findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", id));
        bookToDelete.getAuthors().stream().forEach(author -> author.getBooks().remove(author.getBooks().indexOf(bookToDelete)));
        save(bookToDelete);
        entityManager.flush(); 
        bookRepository.deleteById(id);
        return !bookRepository.existsById(id);
    }

}
