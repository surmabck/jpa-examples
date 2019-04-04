package com.bitecodelab.jpademo.library;

import com.bitecodelab.jpademo.book.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
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
    public List<Library> findCustomByBook(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Library> query = builder.createQuery(Library.class);
        Root<Book> from = query.from(Book.class);
        query.where(builder.equal(from.get("name"),name));
        query.select(from.get("libraries"));
        List<Library> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }
}
