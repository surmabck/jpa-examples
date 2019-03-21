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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "library_books",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        this.books.add(book);
        book.getLibraries().add(this);
    }
    public void removeBook(Book book){
        this.books.remove(book);
        book.getLibraries().remove(this);
    }
}
