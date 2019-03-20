package com.bitecodelab.jpademo.library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Library {
    @Id
    @GeneratedValue
    private Long id;
    private String libraryName;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "library")
    private LibraryAddress address;
}
