package md.utm.fcim.webservice.controller.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.service.AuthorService;
import md.utm.fcim.service.dto.Author;
import md.utm.fcim.webservice.controller.AuthorController;
import md.utm.fcim.webservice.converter.AuthorViewConverter;
import md.utm.fcim.webservice.converter.assembler.AuthorViewAssembler;
import md.utm.fcim.webservice.view.AuthorView;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService service;
    private final AuthorViewConverter converter;
    private final AuthorViewAssembler assembler;

    @Override
    public Response findAll() {
        return Response.ok().entity(service.findAll()
                .stream()
                .map(assembler::toResource)
                .collect(Collectors.toList())).build();
    }

    @Override
    public Response findPage(Integer page, Integer size) {
        return Response.ok().entity(service.findPage(page, size)
                .getContent()
                .stream()
                .map(assembler::toResource)
                .collect(Collectors.toList())).build();
    }

    @Override
    public Response findById(Long id) {
        Optional<Author> dto = service.findById(id);
        return Response.status(dto.isPresent() ? Response.Status.OK : Response.Status.NO_CONTENT)
                .entity(assembler.toResource(dto.orElse(null)))
                .build();
    }

    @Override
    public Response create(AuthorView authorView) {
        return Response.status(Response.Status.CREATED)
                .entity(assembler.toResource(service.create(converter.reverse().convert(authorView))))
                .build();
    }

    @Override
    public Response edit(AuthorView authorView) {
        return Response.ok()
                .entity(assembler.toResource(service.edit(converter.reverse().convert(authorView))))
                .build();
    }
}
