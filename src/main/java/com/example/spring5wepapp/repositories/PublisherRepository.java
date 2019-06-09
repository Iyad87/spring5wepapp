package com.example.spring5wepapp.repositories;

import com.example.spring5wepapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
