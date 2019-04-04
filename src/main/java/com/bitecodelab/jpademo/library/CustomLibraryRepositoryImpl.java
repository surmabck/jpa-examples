package com.bitecodelab.jpademo.library;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomLibraryRepositoryImpl implements CustomLibraryRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Library> findLibrariesWhichHaveGivenBook(String name) {
        Query query = entityManager.createQuery("SELECT b.libraries FROM Book b WHERE b.name = :bookName");
        entityManager.createQuery("SELECT b.libraries FROM Book b WHERE b.name = :bookName");
        query.setParameter("bookName", name);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Library> findCustomById(long id) {
        TypedQuery<Library> query = entityManager.createQuery("SELECT l FROM Library l WHERE l.id = :id", Library.class);
        query.setParameter("id",id);
        List<Library> resultList = query.getResultList();
        return resultList;
    }
}
