package md.utm.fcim.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Author {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private Long age;

    private String gender;

    private Set<Book> books;
}
