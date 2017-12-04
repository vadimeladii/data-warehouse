package md.utm.fcim.webservice.converter;

import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.utm.fcim.service.dto.Author;
import md.utm.fcim.webservice.view.AuthorView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorViewConverter extends Converter<Author, AuthorView> {

    private final BookViewConverter bookViewConverter;

    @Override
    protected AuthorView doForward(Author dto) {
        AuthorView view = new AuthorView();
        view.setIdAuthor(dto.getId());
        view.setFirstName(dto.getFirstName());
        view.setLastName(dto.getLastName());
        view.setAge(dto.getAge());
        view.setGender(dto.getGender());
        view.setBooks(
                dto.getBooks().stream()
                        .map(bookViewConverter::convert)
                        .collect(Collectors.toSet()));
        return view;
    }

    @Override
    protected Author doBackward(AuthorView view) {
        Author dto = new Author();
        dto.setId(view.getIdAuthor());
        dto.setFirstName(view.getFirstName());
        dto.setLastName(view.getLastName());
        dto.setAge(view.getAge());
        dto.setGender(view.getGender());
        dto.setBooks(
                view.getBooks().stream()
                        .map(bookViewConverter.reverse()::convert)
                        .collect(Collectors.toSet()));
        return dto;
    }
}
