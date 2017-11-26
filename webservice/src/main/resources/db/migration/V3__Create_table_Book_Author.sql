CREATE TABLE book_author (
  id SERIAL,
  book_id INTEGER NOT NULL,
  author_id INTEGER NOT NULL,
  FOREIGN KEY (book_id) REFERENCES book(id),
  FOREIGN KEY (author_id) REFERENCES author(id),
  PRIMARY KEY (id)
);