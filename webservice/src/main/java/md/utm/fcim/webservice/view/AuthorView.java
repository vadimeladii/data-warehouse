package md.utm.fcim.webservice.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class AuthorView implements Serializable {

    private static final long serialVersionUID = -4977035781114877769L;

    private Long id;

    private String firstName;

    private String lastName;

    private Long age;

    private String gender;

    private Set<BookView> books;
}