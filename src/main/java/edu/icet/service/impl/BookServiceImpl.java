package edu.icet.service.impl;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final BookRepository repository;

    ModelMapper mapper;

    @Bean
    public void setup(){this.mapper = new ModelMapper(); }

    @Override
    public void addBook(Book book) {
        BookEntity entity = mapper.map(book, BookEntity.class);
        repository.save(entity);
    }

    @Override
    public List<BookEntity> getBooks() {
        return (List<BookEntity>) repository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {return false;}
    }

    @Override
    public Book getBookId(Long id) {
        Optional<BookEntity> byId = repository.findById(id);
        return mapper.map(byId, Book.class);
    }

//    @Override
//    public Book getBookTitle(String title) {
//        Optional<BookEntity> byTitle = repository.findByTitle()
//        return mapper.map(byId, Book.class);
//    }
}
