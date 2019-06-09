package com.example.spring5wepapp.repositories;

import com.example.spring5wepapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
