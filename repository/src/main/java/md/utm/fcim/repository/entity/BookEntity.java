package md.utm.fcim.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "number_of_pages")
    private Long numberOfPages;

    @Column(name = "lang")
    private String lang;

    @ManyToMany(mappedBy = "bookEntities")
    private Set<AuthorEntity> authorEntities;
}
