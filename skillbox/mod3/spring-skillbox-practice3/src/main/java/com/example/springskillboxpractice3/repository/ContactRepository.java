package com.example.springskillboxpractice3.repository;

import com.example.springskillboxpractice3.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
