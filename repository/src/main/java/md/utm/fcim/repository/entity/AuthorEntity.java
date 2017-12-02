package md.utm.fcim.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "author")
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Long age;

    @Column(name = "gender")
    private String gender;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {MERGE, REMOVE, REFRESH, DETACH})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    @BatchSize(size = 20)
    private Set<BookEntity> bookEntities;
}