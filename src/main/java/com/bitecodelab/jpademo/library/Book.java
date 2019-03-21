package com.bitecodelab.jpademo.library;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;
}
