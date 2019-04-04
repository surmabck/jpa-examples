package com.bitecodelab.jpademo.library;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomLibraryRepository {
    List<Library> findLibrariesWhichHaveGivenBook(@Param("bookName") String name);
    List<Library> findCustomByBook(@Param("bookName") String name);
}
