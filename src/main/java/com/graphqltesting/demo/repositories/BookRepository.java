package com.graphqltesting.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqltesting.demo.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
