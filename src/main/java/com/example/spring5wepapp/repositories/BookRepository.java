package com.example.spring5wepapp.repositories;

import com.example.spring5wepapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
