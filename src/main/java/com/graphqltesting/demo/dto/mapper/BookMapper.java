package com.graphqltesting.demo.dto.mapper;

import java.util.List;

import com.graphqltesting.demo.dto.request.BookCreateDTO;
import com.graphqltesting.demo.dto.response.AuthorResponseDTO;
import com.graphqltesting.demo.dto.response.BookResponseDTO;
import com.graphqltesting.demo.models.Author;
import com.graphqltesting.demo.models.Book;

public class BookMapper {

    private BookMapper(){}

    public static Book toEntity(BookCreateDTO bookCreateDTO, List<Author> authorsList){
        return new Book(bookCreateDTO.title(), bookCreateDTO.publicationYear(), authorsList);

    }

    public static BookResponseDTO toDTO(Book book){
        List<AuthorResponseDTO> authorResponse = book.getAuthors().stream().map(author -> AuthorMapper.toDTO(author)).toList();
        return new BookResponseDTO(book.getId(), book.getTitle(), book.getPublicationYear(), authorResponse);

    }

}
