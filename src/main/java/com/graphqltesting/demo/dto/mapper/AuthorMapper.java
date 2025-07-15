package com.graphqltesting.demo.dto.mapper;

import com.graphqltesting.demo.dto.response.AuthorResponseDTO;
import com.graphqltesting.demo.models.Author;

public class AuthorMapper {

    private AuthorMapper() {
    }

    public static AuthorResponseDTO toDTO(Author author) {
        return new AuthorResponseDTO(author.getId(), author.getName(), author.getNationality());
    }

    public static Author toEntity(AuthorResponseDTO authorResponseDTO) {
        return new Author(authorResponseDTO.id(), authorResponseDTO.name(), authorResponseDTO.nationality());
    }
}
