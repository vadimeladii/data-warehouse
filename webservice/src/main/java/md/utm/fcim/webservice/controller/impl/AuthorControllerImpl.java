package md.utm.fcim.webservice.controller.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.service.AuthorService;
import md.utm.fcim.webservice.controller.AuthorController;
import md.utm.fcim.webservice.converter.AuthorViewConverter;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService service;
    private final AuthorViewConverter converter;

    @Override
    public Response findAll() {
        return Response.ok().entity(service.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList())).build();
    }

    @Override
    public Response findPage(Integer page, Integer size) {
        return Response.ok().entity(service.findPage(page, size)
                .getContent()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList())).build();
    }

    @Override
    public Response findById(Long id) {
        return Response.ok()
                .entity(converter.convert(service.findById(id)))
                .build();
    }
}
