package com.graphqltesting.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqltesting.demo.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
