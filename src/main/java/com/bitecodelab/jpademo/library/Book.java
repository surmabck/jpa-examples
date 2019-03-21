package com.bitecodelab.jpademo.library;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor (staticName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @EqualsAndHashCode.Include
    private String name;

    @ManyToMany(mappedBy = "books")
    private List<Library> libraries = new ArrayList<>();
}
