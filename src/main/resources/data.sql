-- Authors Insertions
INSERT INTO author (id, name, nationality) VALUES (1, 'J.R.R. Tolkien', 'British');
INSERT INTO author (id, name, nationality) VALUES (2, 'George Orwell', 'British');
INSERT INTO author (id, name, nationality) VALUES (3, 'Jane Austen', 'British');
INSERT INTO author (id, name, nationality) VALUES (4, 'Terry Pratchett', 'British');
INSERT INTO author (id, name, nationality) VALUES (5, 'Neil Gaiman', 'British');



-- Book Insertions
INSERT INTO book (id, title, publication_year) VALUES (1, 'The Hobbit', 1937);
INSERT INTO book (id, title, publication_year) VALUES (2, '1984', 1949);
INSERT INTO book (id, title, publication_year) VALUES (3, 'Animal Farm', 1945);
INSERT INTO book (id, title, publication_year) VALUES (4, 'Pride and Prejudice', 1813);
INSERT INTO book (id, title, publication_year) VALUES (5, 'Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch', 1990);


-- Author-Book Relationships
INSERT INTO book_authors (author_id, book_id) VALUES (1, 1); 
INSERT INTO book_authors (author_id, book_id) VALUES (2, 2); 
INSERT INTO book_authors (author_id, book_id) VALUES (2, 3); 
INSERT INTO book_authors (author_id, book_id) VALUES (4, 4); 
INSERT INTO book_authors (author_id, book_id) VALUES (5, 4); 