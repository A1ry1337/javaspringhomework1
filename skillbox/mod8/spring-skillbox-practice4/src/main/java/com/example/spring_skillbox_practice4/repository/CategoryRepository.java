package com.example.spring_skillbox_practice4.repository;

import com.example.spring_skillbox_practice4.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
