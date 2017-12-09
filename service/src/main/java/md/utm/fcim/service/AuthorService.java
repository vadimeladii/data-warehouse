package md.utm.fcim.service;

import md.utm.fcim.service.dto.Author;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Page<Author> findPage(Integer page, Integer size);

    Author create(@Valid Author author);

    Author edit(@Valid Author author);
}