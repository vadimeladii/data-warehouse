package md.utm.fcim.service.converter;

import com. google.common.base.Converter;
import md.utm.fcim.repository.entity.BookEntity;
import md.utm.fcim.service.dto.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter extends Converter<BookEntity, Book> {

    @Override
    protected Book doForward(BookEntity entity) {
        Book dto = new Book();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setGenre(entity.getGenre());
        dto.setAuthorId(entity.getAuthorId());
        dto.setNumberOfPages(entity.getNumberOfPages());
        dto.setLang(entity.getLang());
        return dto;
    }

    @Override
    protected BookEntity doBackward(Book dto) {
        BookEntity entity = new BookEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setGenre(dto.getGenre());
        entity.setAuthorId(dto.getAuthorId());
        entity.setNumberOfPages(dto.getNumberOfPages());
        entity.setLang(dto.getLang());
        return entity;
    }
}
