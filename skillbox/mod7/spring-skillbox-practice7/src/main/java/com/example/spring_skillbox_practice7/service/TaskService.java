package com.example.spring_skillbox_practice7.service;


import com.example.spring_skillbox_practice7.model.Task;
import com.example.spring_skillbox_practice7.model.User;
import com.example.spring_skillbox_practice7.repository.TaskRepository;
import com.example.spring_skillbox_practice7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.HashSet;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // Получение всех задач с подробной информацией об авторе, исполнителе и наблюдателях
    public Flux<Task> findAllTasksWithDetails() {
        return taskRepository.findAll()
                .flatMap(this::loadTaskDetails);
    }

    // Получение задачи по ID с подробной информацией
    public Mono<Task> findTaskByIdWithDetails(String id) {
        return taskRepository.findById(id)
                .flatMap(this::loadTaskDetails);
    }

    // Создание новой задачи
    public Mono<Task> createTask(Task task) {
        task.setCreatedAt(Instant.now());
        task.setUpdatedAt(Instant.now());
        return taskRepository.save(task);
    }

    // Обновление задачи по ID
    public Mono<Task> updateTask(String id, Task task) {
        return taskRepository.findById(id)
                .flatMap(existingTask -> {
                    existingTask.setName(task.getName());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setStatus(task.getStatus());
                    existingTask.setUpdatedAt(Instant.now());
                    return taskRepository.save(existingTask);
                });
    }

    // Добавление наблюдателя в задачу
    public Mono<Task> addObserver(String taskId, String observerId) {
        return taskRepository.findById(taskId)
                .flatMap(task -> userRepository.findById(observerId)
                        .flatMap(observer -> {
                            task.getObserverIds().add(observerId);
                            return taskRepository.save(task);
                        })
                );
    }

    // Удаление задачи по ID
    public Mono<Void> deleteTask(String id) {
        return taskRepository.deleteById(id);
    }

    // Загрузка дополнительных данных задачи: автор, исполнитель, наблюдатели
    private Mono<Task> loadTaskDetails(Task task) {
        Mono<User> authorMono = userRepository.findById(task.getAuthorId());
        Mono<User> assigneeMono = userRepository.findById(task.getAssigneeId());
        Flux<User> observersFlux = Flux.fromIterable(task.getObserverIds())
                .flatMap(userRepository::findById);

        return Mono.zip(authorMono, assigneeMono, observersFlux.collectList())
                .map(tuple -> {
                    task.setAuthor(tuple.getT1());
                    task.setAssignee(tuple.getT2());
                    task.setObservers(new HashSet<>(tuple.getT3()));
                    return task;
                });
    }
}

