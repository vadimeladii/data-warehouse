package md.utm.fcim.webservice.controller.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.webservice.controller.BookController;
import md.utm.fcim.webservice.converter.BookViewConverter;
import md.utm.fcim.webservice.view.BookView;
import md.utm.fcim.service.BookService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;
    private final BookViewConverter converter;

    @Override
    public List<BookView> findAll() {
        return bookService.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public BookView findById(Long id) {
        return converter.convert(bookService.findById(id));
    }
}
