package md.utm.fcim.service.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.repository.AuthorRepository;
import md.utm.fcim.service.AuthorService;
import md.utm.fcim.service.converter.AuthorConverter;
import md.utm.fcim.service.dto.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorConverter converter;

    @Override
    public List<Author> findAll() {
        return repository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Author findById(Long id) {
        return converter.convert(repository.findOne(id));
    }
}