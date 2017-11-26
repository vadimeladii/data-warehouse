CREATE TABLE book (
    id SERIAL,
    title VARCHAR NOT NULL,
    genre VARCHAR NOT NULL,
    number_of_pages INTEGER NOT NULL,
    lang VARCHAR NOT NULL,
    PRIMARY KEY (id)
);