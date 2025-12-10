package com.my_apps.mybookmongo.repository;

import com.my_apps.mybookmongo.model.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookModel, Long> {

}
