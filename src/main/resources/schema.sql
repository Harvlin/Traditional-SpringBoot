DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    age INTEGER,
    CONSTRAINT authors_pkey PRIMARY KEY (id)
);

CREATE TABLE books (
    isbn VARCHAR(255) NOT NULL,
    title VARCHAR(255),
    author_id BIGINT,
    CONSTRAINT books_pkey PRIMARY KEY (isbn),
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors(id)
);
