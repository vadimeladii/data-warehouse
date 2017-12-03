package md.utm.fcim.service.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.common.error.EntityNotFoundException;
import md.utm.fcim.common.error.IllegalArgumentException;
import md.utm.fcim.common.error.WrongUrlIdException;
import md.utm.fcim.repository.BookRepository;
import md.utm.fcim.service.BookService;
import md.utm.fcim.service.converter.BookConverter;
import md.utm.fcim.service.dto.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static md.utm.fcim.common.expression.ExpressionAsserts.verify;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookConverter converter;

    @Override
    public List<Book> findAll() {
        return repository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(converter.convert(repository.findOne(id)));
    }

    @Override
    public Page<Book> findPage(Integer page, Integer size) {
        return repository.findAll(new PageRequest(page, size)).map(converter::convert);
    }

    @Override
    public Book create(Book book) {
        verify(book.getId() != null, () -> new IllegalArgumentException("Book Id should be null"));
        return converter.convert(repository.save(converter.reverse().convert(book)));
    }

    @Override
    public Book edit(Long id, Book book) {
        verify(!book.getId().equals(id), () -> new WrongUrlIdException(Book.class, book.getId(), id));
        verify(!repository.exists(id), () -> new EntityNotFoundException(Book.class, id));
        return converter.convert(repository.save(converter.reverse().convert(book)));
    }
}
