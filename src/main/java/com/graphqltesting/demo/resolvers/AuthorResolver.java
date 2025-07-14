package com.graphqltesting.demo.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphqltesting.demo.models.Author;
import com.graphqltesting.demo.models.Book;
import com.graphqltesting.demo.services.AuthorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorResolver {

    private final AuthorService authorService;

    
    @QueryMapping(name="authors")
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @SchemaMapping(field="authors")
    public List<Author> findByBookId(Book book){
        return authorService.findByBookId(book.getId());
    }
}
