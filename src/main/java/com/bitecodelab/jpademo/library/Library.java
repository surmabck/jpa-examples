package com.bitecodelab.jpademo.library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Library {
    @Id
    @GeneratedValue
    private Long id;
    private String libraryName;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "library_books",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        this.books.add(book);
        book.getLibraries().add(this);
    }
    public void removeBook(Book book){
        this.books.remove(book);
        book.getLibraries().remove(this);
    }
}
