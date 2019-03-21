package com.bitecodelab.jpademo.book;

import com.bitecodelab.jpademo.library.Library;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor (staticName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Book {

    @Id
    @NaturalId
    @EqualsAndHashCode.Include
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "books")
    @ToString.Exclude
    private Set<Library> libraries = new HashSet<>();
}
