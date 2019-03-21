package com.bitecodelab.jpademo.library;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor (staticName = "of")
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;
}
