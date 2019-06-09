package com.example.spring5wepapp.bootstrap;

import com.example.spring5wepapp.domain.Author;
import com.example.spring5wepapp.domain.Book;
import com.example.spring5wepapp.domain.Publisher;
import com.example.spring5wepapp.repositories.AuthorRepository;
import com.example.spring5wepapp.repositories.BookRepository;
import com.example.spring5wepapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher foo = new Publisher();
        foo.setName("foo");

        publisherRepository.save(foo);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driver Design", "1234", foo);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2344", foo);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
