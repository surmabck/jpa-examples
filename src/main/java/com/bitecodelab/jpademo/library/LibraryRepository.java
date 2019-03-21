package com.bitecodelab.jpademo.library;

import com.bitecodelab.jpademo.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {


    @Query("SELECT b.libraries FROM Book b WHERE b.name = :bookName")
    List<Library> findLibrariesWhichHaveGivenBook(@Param("bookName") String name);

    List<Library> findCustomByBook(@Param("bookName") String name);

    List<Library> findCustomByName(String name);

}
