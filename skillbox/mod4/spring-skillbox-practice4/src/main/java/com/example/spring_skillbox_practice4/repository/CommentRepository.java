package com.example.spring_skillbox_practice4.repository;

import com.example.spring_skillbox_practice4.model.AccountUser;
import com.example.spring_skillbox_practice4.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
