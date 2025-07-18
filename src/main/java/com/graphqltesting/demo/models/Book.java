package com.graphqltesting.demo.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int publicationYear;

    @ManyToMany(mappedBy="books")
    private List<Author> authors;

    public Book(String title, int publicationYear, List<Author> authors){
        this.title = title;
        this.publicationYear = publicationYear;
        this.authors = authors;
    }

}
