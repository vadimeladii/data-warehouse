package md.utm.fcim.webservice.converter;

import com.google.common.base.Converter;
import md.utm.fcim.webservice.view.BookView;
import md.utm.fcim.service.dto.Book;
import org.springframework.stereotype.Component;

@Component
public class BookViewConverter extends Converter<Book, BookView> {

    @Override
    protected BookView doForward(Book dto) {
        BookView view = new BookView();
        view.setId(dto.getId());
        view.setTitle(dto.getTitle());
        view.setGenre(dto.getGenre());
        view.setAuthorId(dto.getAuthorId());
        view.setNumberOfPages(dto.getNumberOfPages());
        view.setLang(dto.getLang());
        return view;
    }

    @Override
    protected Book doBackward(BookView view) {
        Book dto = new Book();
        dto.setId(view.getId());
        dto.setTitle(view.getTitle());
        dto.setGenre(view.getGenre());
        dto.setAuthorId(view.getAuthorId());
        dto.setNumberOfPages(view.getNumberOfPages());
        dto.setLang(view.getLang());
        return dto;
    }
}