package com.example.springskillboxpractice1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    // Добавить контакт
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Удалить контакт по email
    public boolean deleteContactByEmail(String email) {
        return contacts.removeIf(contact -> contact.getEmail().equals(email));
    }

    // Получить все контакты
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts); // возвращаем копию списка
    }
}
