package com.graphqltesting.demo.resolvers;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqltesting.demo.models.Book;
import com.graphqltesting.demo.services.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookResolver {

    private final BookService bookService;

    @QueryMapping(name="books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

}
