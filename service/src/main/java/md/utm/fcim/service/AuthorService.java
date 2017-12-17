package md.utm.fcim.service;

import md.utm.fcim.service.dto.Author;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Validated
public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(@NotNull Long id);

    Page<Author> findPage(@NotNull Integer page, @NotNull Integer size);

    Author create(@Valid Author author);

    Author edit(@NotNull Long id, @Valid Author author);
}