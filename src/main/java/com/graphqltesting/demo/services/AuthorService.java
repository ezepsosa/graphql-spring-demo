package com.graphqltesting.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphqltesting.demo.models.Author;
import com.graphqltesting.demo.repositories.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

}
