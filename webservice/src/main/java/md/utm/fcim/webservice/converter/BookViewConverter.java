package md.utm.fcim.webservice.converter;

import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.utm.fcim.webservice.view.BookView;
import md.utm.fcim.service.dto.Book;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookViewConverter extends Converter<Book, BookView> {

    @Override
    protected BookView doForward(Book dto) {
        BookView view = new BookView();
        view.setIdBook(dto.getId());
        view.setTitle(dto.getTitle());
        view.setGenre(dto.getGenre());
        view.setNumberOfPages(dto.getNumberOfPages());
        view.setLang(dto.getLang());
        return view;
    }

    @Override
    protected Book doBackward(BookView view) {
        Book dto = new Book();
        dto.setId(view.getIdBook());
        dto.setTitle(view.getTitle());
        dto.setGenre(view.getGenre());
        dto.setNumberOfPages(view.getNumberOfPages());
        dto.setLang(view.getLang());
        return dto;
    }
}