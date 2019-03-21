package com.bitecodelab.jpademo.library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Library {
    @Id
    @GeneratedValue
    private Long id;
    private String libraryName;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "library",
            orphanRemoval = true
    )
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        this.books.add(book);
        book.setLibrary(this);
    }
    public void removeBook(Book book){
        this.books.remove(book);
        book.setLibrary(null);
    }
}
