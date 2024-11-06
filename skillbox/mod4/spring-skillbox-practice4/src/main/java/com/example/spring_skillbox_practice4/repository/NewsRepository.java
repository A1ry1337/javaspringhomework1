package com.example.spring_skillbox_practice4.repository;

import com.example.spring_skillbox_practice4.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    // Вы можете добавить методы для поиска новостей по категориям, авторам и т. д.
}