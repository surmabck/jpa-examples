package com.bitecodelab.jpademo;

import com.bitecodelab.jpademo.library.Book;
import com.bitecodelab.jpademo.library.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

@Component
@Transactional
@Order(1)
public class InitialDataLoader implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(InitialDataLoader.class);
    private final EntityManager em;

    public InitialDataLoader(EntityManager em) {
        this.em = em;
    }
    @Override
    public void run(String... args) throws Exception {
        Library library = new Library();
        library.setLibraryName("library1");
        library.addBook(Book.of("Book1"));
        library.addBook(Book.of("Book2"));
        library.addBook(Book.of("Book3"));
        doInsert(library);
        doUpdate(library);
        library = doFetch(library);
        doDelete(library);
    }
    private void doInsert(Library library){
        logger.info("do insert");
        em.persist(library);
        em.flush();
    }
    private void doUpdate(Library library){
        logger.info("do update");
        library.setLibraryName("library name changed");
        em.persist(library);
        em.flush();
    }
    @Transactional
    private Library doFetch(Library library){
        logger.info("do fetch");
        em.detach(library);
        return em.find(Library.class,library.getId());
    }
    @Transactional
    private void doDelete(Library library){
        logger.info("do delete");
        Book book = library.getBooks().get(0);
        library.removeBook(book);
        em.flush();
    }
}
