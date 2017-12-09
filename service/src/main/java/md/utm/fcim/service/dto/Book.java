package md.utm.fcim.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String genre;

    @NotNull
    private Long numberOfPages;

    @NotNull
    private String lang;
}
