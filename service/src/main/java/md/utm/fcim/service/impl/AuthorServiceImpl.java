package md.utm.fcim.service.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.common.error.EntityNotFoundException;
import md.utm.fcim.common.error.IllegalArgumentException;
import md.utm.fcim.common.error.WrongUrlIdException;
import md.utm.fcim.repository.AuthorRepository;
import md.utm.fcim.service.AuthorService;
import md.utm.fcim.service.converter.AuthorConverter;
import md.utm.fcim.service.dto.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static md.utm.fcim.common.expression.ExpressionAsserts.verify;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorConverter converter;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return repository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(converter.convert(repository.findOne(id)));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Author> findPage(Integer page, Integer size) {
        return repository.findAll(new PageRequest(page, size)).map(converter::convert);
    }

    @Override
    public Author create(Author author) {
        verify(author.getId() != null, () -> new IllegalArgumentException("Author Id should be null"));
        return converter.convert(repository.save(converter.reverse().convert(author)));
    }

    @Override
    public Author edit(Long id, Author author) {
        verify(!author.getId().equals(id), () -> new WrongUrlIdException(Author.class, author.getId(), id));
        verify(!repository.exists(id), () -> new EntityNotFoundException(Author.class, id));
        return converter.convert(repository.save(converter.reverse().convert(author)));
    }
}