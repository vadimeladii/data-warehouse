package md.utm.fcim.service;

import md.utm.fcim.service.dto.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Long id);
}