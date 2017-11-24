package md.utm.fcim.webservice.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class BookView implements Serializable {

    private static final long serialVersionUID = 4022451271475123464L;

    private Long id;

    private String title;

    private String genre;

    private Long authorId;

    private Long numberOfPages;

    private String lang;
}
