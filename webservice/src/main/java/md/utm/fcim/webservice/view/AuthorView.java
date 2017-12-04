package md.utm.fcim.webservice.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class AuthorView extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -4977035781114877769L;

    private Long idAuthor;

    private String firstName;

    private String lastName;

    private Long age;

    private String gender;

    private Set<BookView> books;
}