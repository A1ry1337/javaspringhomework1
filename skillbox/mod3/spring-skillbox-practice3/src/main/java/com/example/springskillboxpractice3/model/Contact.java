package com.example.springskillboxpractice3.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity // JPA АННОТАЦИЯ указывает на то, что этот класс - сущность таблицы из бд
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}