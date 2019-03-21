package com.bitecodelab.jpademo.book;

import com.bitecodelab.jpademo.library.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findByLibraries(Library library);

}
