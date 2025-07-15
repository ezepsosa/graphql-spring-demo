package com.graphqltesting.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.dto.mapper.AuthorMapper;
import com.graphqltesting.demo.dto.response.AuthorResponseDTO;
import com.graphqltesting.demo.exceptions.ResourceNotFoundException;
import com.graphqltesting.demo.models.Author;
import com.graphqltesting.demo.repositories.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<AuthorResponseDTO> findAll() {
        return authorRepository.findAll().stream().map(AuthorMapper::toDTO).toList();
    }

    public Optional<AuthorResponseDTO> findById(Long id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Author", id));
        return Optional.of(AuthorMapper.toDTO(author));
    }

}
