package md.utm.fcim.service;

import md.utm.fcim.service.dto.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);
}