package com.code.myapps.mybook.repository;

import com.code.myapps.mybook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
