package com.graphqltesting.demo.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqltesting.demo.dto.request.BookCreateDTO;
import com.graphqltesting.demo.dto.request.BookUpdateDTO;
import com.graphqltesting.demo.dto.response.BookResponseDTO;
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

    @MutationMapping(name="createBook")
    public BookResponseDTO save(@Argument("insertBook") BookCreateDTO insertBook){
        return libraryService.saveBook(insertBook);
    }

    @MutationMapping(name="updateBook")
    public Book update(@Argument("updateBook") BookUpdateDTO bookUpdateDTO){
        return libraryService.updateBook(bookUpdateDTO);
    }

    @MutationMapping(name = "deleteBook")
    public Boolean delete(@Argument("id") Long id){
        return bookService.delete(id);
    }
}
