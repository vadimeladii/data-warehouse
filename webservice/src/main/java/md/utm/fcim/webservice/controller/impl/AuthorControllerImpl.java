package md.utm.fcim.webservice.controller.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.service.AuthorService;
import md.utm.fcim.webservice.controller.AuthorController;
import md.utm.fcim.webservice.converter.AuthorViewConverter;
import md.utm.fcim.webservice.view.AuthorView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService service;
    private final AuthorViewConverter converter;

    @Override
    public List<AuthorView> findAll() {
        return service.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorView findById(Long id) {
        return converter.convert(service.findById(id));
    }
}
