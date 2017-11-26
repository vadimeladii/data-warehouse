package md.utm.fcim.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Author {

    private Long id;

    private String firstName;

    private String lastName;

    private Long age;

    private String gender;

    private Set<Book> books;
}
