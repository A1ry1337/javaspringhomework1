package com.example.spring_skillbox_practice7.repository;

import com.example.spring_skillbox_practice7.model.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TaskRepository extends ReactiveMongoRepository<Task, String> {
}