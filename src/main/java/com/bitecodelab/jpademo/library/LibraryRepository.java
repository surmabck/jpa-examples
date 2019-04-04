package com.bitecodelab.jpademo.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>, CustomLibraryRepository {

    List<Library> findCustomByName(String name);

}
