package com.myapps.mybooksql.repository;

import com.myapps.mybooksql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
