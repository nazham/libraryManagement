package edu.icet.service.impl;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository repository;

    ModelMapper mapper;

    @Bean
    public void setup(){this.mapper = new ModelMapper(); }

    @Override
    public void addBook(Book book) {
        BookEntity entity = mapper.map(book, BookEntity.class);
        repository.save(entity);
    }
}
