-- Authors Insertions
INSERT INTO author (name, nationality) VALUES ('J.R.R. Tolkien', 'British');
INSERT INTO author (name, nationality) VALUES ('George Orwell', 'British');
INSERT INTO author (name, nationality) VALUES ('Jane Austen', 'British');
INSERT INTO author (name, nationality) VALUES ('Terry Pratchett', 'British');
INSERT INTO author (name, nationality) VALUES ('Neil Gaiman', 'British');



-- Book Insertions
INSERT INTO book (title, publication_year) VALUES ('The Hobbit', 1937);
INSERT INTO book (title, publication_year) VALUES ('1984', 1949);
INSERT INTO book (title, publication_year) VALUES ('Animal Farm', 1945);
INSERT INTO book (title, publication_year) VALUES ('Pride and Prejudice', 1813);
INSERT INTO book (title, publication_year) VALUES ('Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch', 1990);


-- Author-Book Relationships
INSERT INTO book_authors (author_id, book_id) VALUES (1, 1); 
INSERT INTO book_authors (author_id, book_id) VALUES (2, 2); 
INSERT INTO book_authors (author_id, book_id) VALUES (2, 3); 
INSERT INTO book_authors (author_id, book_id) VALUES (4, 4); 
INSERT INTO book_authors (author_id, book_id) VALUES (5, 4); 