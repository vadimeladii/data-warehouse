package md.utm.fcim.webservice.converter.assembler;

import md.utm.fcim.common.hateoas.JaxRsResourceAssemblerSupport;
import md.utm.fcim.service.dto.Author;
import md.utm.fcim.webservice.controller.AuthorController;
import md.utm.fcim.webservice.converter.AuthorViewConverter;
import md.utm.fcim.webservice.view.AuthorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorViewAssembler extends JaxRsResourceAssemblerSupport<Author, AuthorView> {

    @Autowired
    private AuthorViewConverter converter;

    @Autowired
    private BookViewAssembler bookViewAssembler;

    public AuthorViewAssembler() {
        super(AuthorController.class, AuthorView.class);
    }

    @Override
    public AuthorView toResource(Author dto) {
        return correctedToResource(dto);
    }

    private AuthorView correctedToResource(Author dto) {
        return dto == null ? null : converter(dto);
    }

    private AuthorView converter(Author dto) {
        AuthorView view = createResourceWithId(dto.getId(), dto);
        AuthorView result = converter.convert(dto);
        result.add(view.getLinks());
        result.setBooks(dto.getBooks().stream().map(bookViewAssembler::toResource).collect(Collectors.toSet()));
        return result;
    }
}
