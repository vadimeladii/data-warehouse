package md.utm.fcim.webservice.controller.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.service.dto.Book;
import md.utm.fcim.webservice.controller.BookController;
import md.utm.fcim.webservice.converter.BookViewConverter;
import md.utm.fcim.service.BookService;
import md.utm.fcim.webservice.view.BookView;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService service;
    private final BookViewConverter converter;

    @Override
    public Response findAll() {
        return Response.ok()
                .entity(service.findAll()
                        .stream()
                        .map(converter::convert)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public Response findPage(Integer page, Integer size) {
        return Response.ok()
                .entity(service.findPage(page, size))
                .build();
    }

    @Override
    public Response findById(Long id) {
        Optional<Book> dto = service.findById(id);
        return Response
                .status(dto.isPresent() ? Response.Status.OK : Response.Status.NO_CONTENT)
                .entity(converter.convert(dto.orElse(null)))
                .build();
    }

    @Override
    public Response create(BookView bookView) {
        return Response.status(Response.Status.CREATED)
                .entity(service.create(converter.reverse().convert(bookView)))
                .build();
    }

    @Override
    public Response edit(Long id, BookView bookView) {
        return Response.ok()
                .entity(service.edit(id, converter.reverse().convert(bookView)))
                .build();
    }
}
