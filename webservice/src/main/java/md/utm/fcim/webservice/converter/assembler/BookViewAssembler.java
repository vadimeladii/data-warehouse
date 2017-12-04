package md.utm.fcim.webservice.converter.assembler;

import md.utm.fcim.common.hateoas.JaxRsResourceAssemblerSupport;
import md.utm.fcim.service.dto.Book;
import md.utm.fcim.webservice.controller.BookController;
import md.utm.fcim.webservice.converter.BookViewConverter;
import md.utm.fcim.webservice.view.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookViewAssembler extends JaxRsResourceAssemblerSupport<Book, BookView> {

    @Autowired
    private BookViewConverter converter;

    public BookViewAssembler() {
        super(BookController.class, BookView.class);
    }

    @Override
    public BookView toResource(Book dto) {
        BookView view = createResourceWithId(dto.getId(), dto);
        BookView result = converter.convert(dto);
        result.add(view.getLinks());
        return result;
    }

}
