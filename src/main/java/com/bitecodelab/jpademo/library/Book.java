package com.bitecodelab.jpademo.library;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Book {

    @Id
    @NaturalId
    @EqualsAndHashCode.Include
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "books")
    private Set<Library> libraries = new HashSet<>();
}
