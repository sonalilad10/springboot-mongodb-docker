package com.okta.mongodb.springbootmongodbdocker.dao;

import com.okta.mongodb.springbootmongodbdocker.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book, Integer> {
}
