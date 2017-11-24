package md.utm.fcim.service.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.repository.BookRepository;
import md.utm.fcim.service.BookService;
import md.utm.fcim.service.converter.BookConverter;
import md.utm.fcim.service.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Book findById(Long id) {
        return converter.convert(repository.findOne(id));
    }
}
