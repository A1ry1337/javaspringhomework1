package com.example.spring_skillbox_practice5.repository;

import com.example.spring_skillbox_practice5.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitleAndAuthor(String title, String author);
    List<Book> findByCategoryName(String categoryName);
}