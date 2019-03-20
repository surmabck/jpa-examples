package com.bitecodelab.jpademo.library;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Long> {
}
