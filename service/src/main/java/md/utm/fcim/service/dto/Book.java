package md.utm.fcim.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private Long id;

    private String title;

    private String genre;

    private Long numberOfPages;

    private String lang;
}
