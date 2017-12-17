package md.utm.fcim.service;

import md.utm.fcim.service.dto.Book;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Validated
public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(@NotNull Long id);

    Page<Book> findPage(@NotNull Integer page, @NotNull Integer size);

    Book create(@Valid Book book);

    Book edit(@NotNull Long id, @Valid Book book);
}