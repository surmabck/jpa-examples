package com.bitecodelab.jpademo.library;

import com.bitecodelab.jpademo.book.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Lib")
@NamedQuery(name = "Library.findCustomByBook",query = "SELECT b.libraries FROM Book b WHERE b.name = :bookName")
@NamedQueries( value = {@NamedQuery(name = "Library.findCustomByName",query = "SELECT library FROM Library library WHERE library.libraryName= ?1")})
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
