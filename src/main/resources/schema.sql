DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    age INT,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE books (
    isbn VARCHAR(255) NOT NULL,
    title VARCHAR(255),
    author_id BIGINT,
    PRIMARY KEY (isbn),
    FOREIGN KEY (author_id) REFERENCES authors(id)
                   ON DELETE CASCADE
                   ON UPDATE CASCADE
)ENGINE=InnoDB;
