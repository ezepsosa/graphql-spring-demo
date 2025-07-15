package com.graphqltesting.demo.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqltesting.demo.dto.InsertBook;
import com.graphqltesting.demo.models.Book;
import com.graphqltesting.demo.services.BookService;
import com.graphqltesting.demo.services.LibraryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookResolver {

    private final BookService bookService;
    private final LibraryService libraryService;

    @QueryMapping(name="books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument("input") InsertBook insertBook){
        return libraryService.saveBook(insertBook);
    }
}
