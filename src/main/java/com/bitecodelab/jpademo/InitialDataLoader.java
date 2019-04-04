package com.bitecodelab.jpademo;

import com.bitecodelab.jpademo.book.Book;
import com.bitecodelab.jpademo.book.BookRepository;
import com.bitecodelab.jpademo.library.Library;
import com.bitecodelab.jpademo.library.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

@Component
@Transactional
@Order(1)
@Slf4j
public class InitialDataLoader implements CommandLineRunner {
    private final EntityManager em;
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    public InitialDataLoader(EntityManager em, BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.em = em;
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.of("Book1");
        Book book2 = Book.of("Book2");
        Book book22 = Book.of("Book22");
        Book book3 = Book.of("Book3");
        Library library = new Library();
        library.setLibraryName("library1");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Library library2 = new Library();
        library2.setLibraryName("library2");
        library2.addBook(book1);
        library2.addBook(book22);
        library2.addBook(book3);

        doInsert(library);
        doInsert(library2);

        log.info("Library with name {}: {}",library.getLibraryName(), libraryRepository.findCustomByName(library.getLibraryName()));
        log.info("Books in library: {} : {}",library.getLibraryName(),bookRepository.findByLibraries(library));
        log.info("Books in library: {} : {}",library2.getLibraryName(),bookRepository.findByLibraries(library2));
        log.info("Book {} is available in libraries: {}",book1.getName(),libraryRepository.findLibrariesWhichHaveGivenBook(book1.getName()));
        log.info("Library for id {} : {}",library.getId(),libraryRepository.findCustomById(library.getId()));

    }
    private void doInsert(Library library){
        log.info("do insert");
        em.persist(library);
        em.flush();
    }

}
