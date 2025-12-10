package com.code.myapps.mybook.repository;

import com.code.myapps.mybook.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
