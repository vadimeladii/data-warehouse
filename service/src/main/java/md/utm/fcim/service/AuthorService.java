package md.utm.fcim.service;

import md.utm.fcim.service.dto.Author;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Page<Author> findPage(Integer page, Integer size);

    Author create(Author author);

    Author edit(Author author);
}