package com.bitecodelab.jpademo;

import com.bitecodelab.jpademo.library.Library;
import com.bitecodelab.jpademo.library.LibraryAddress;
import com.bitecodelab.jpademo.library.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

@Component
@Transactional
public class InitialDataLoader implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(InitialDataLoader.class);
    private final EntityManager em;

    public InitialDataLoader(EntityManager em) {
        this.em = em;
    }
    @Override
    public void run(String... args) throws Exception {
        LibraryAddress libraryAddress = new LibraryAddress();
        libraryAddress.setCity("Kielce");
        libraryAddress.setHouseNumber(15);
        libraryAddress.setState("Swietokrzyskie");
        libraryAddress.setStreetAddress("Olszewskiego");
        libraryAddress.setZipCode("25-212");
        Library library = new Library();
        library.setLibraryName("library1");
        doInsert(library,libraryAddress);
        doUpdate(library);
        library = doFetch(library);
        doDelete(library);
    }
    private void doInsert(Library library, LibraryAddress address){
        logger.info("do insert");
        library.setAddress(address);
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
        em.remove(library);
        em.flush();
    }
}
