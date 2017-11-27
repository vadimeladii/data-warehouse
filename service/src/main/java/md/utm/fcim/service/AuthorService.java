package md.utm.fcim.service;

import md.utm.fcim.service.dto.Author;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    Page<Author> findPage(Integer page, Integer size);
}