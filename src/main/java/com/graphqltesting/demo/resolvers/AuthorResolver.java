package com.graphqltesting.demo.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphqltesting.demo.dto.response.AuthorResponseDTO;
import com.graphqltesting.demo.dto.response.BookResponseDTO;
import com.graphqltesting.demo.services.AuthorService;
import com.graphqltesting.demo.services.LibraryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorResolver {

    private final AuthorService authorService;
    private final LibraryService libraryService;
    
    @QueryMapping(name="authors")
    public List<AuthorResponseDTO> findAll(){
        return authorService.findAll();
    }

    @SchemaMapping(field="authors")
    public List<AuthorResponseDTO> findByBookId(BookResponseDTO book){
        return libraryService.findAuthorByBookId(book.id());
    }
}
