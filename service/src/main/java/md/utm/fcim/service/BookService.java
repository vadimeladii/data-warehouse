package md.utm.fcim.service;

import md.utm.fcim.service.dto.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Page<Book> findPage(Integer page, Integer size);

    Book create(Book book);

    Book edit(Book book);
}