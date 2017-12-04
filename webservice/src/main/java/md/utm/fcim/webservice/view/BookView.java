package md.utm.fcim.webservice.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class BookView extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 4022451271475123464L;

    private Long idBook;

    private String title;

    private String genre;

    private Long numberOfPages;

    private String lang;
}