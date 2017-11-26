package md.utm.fcim.service.converter;

import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.utm.fcim.repository.entity.AuthorEntity;
import md.utm.fcim.service.dto.Author;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorConverter extends Converter<AuthorEntity, Author> {

    private final BookConverter bookConverter;

    @Override
    protected Author doForward(AuthorEntity entity) {
        Author dto = new Author();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setBooks(
                entity.getBookEntities()
                        .stream()
                        .map(bookConverter::convert)
                        .collect(Collectors.toSet()));
        return dto;
    }

    @Override
    protected AuthorEntity doBackward(Author dto) {
        AuthorEntity entity = new AuthorEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setBookEntities(
                dto.getBooks()
                        .stream()
                        .map(bookConverter.reverse()::convert)
                        .collect(Collectors.toSet()));
        return entity;
    }
}
