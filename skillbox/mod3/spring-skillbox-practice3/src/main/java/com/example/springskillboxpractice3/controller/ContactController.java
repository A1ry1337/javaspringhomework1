package com.example.springskillboxpractice3.controller;

import com.example.springskillboxpractice3.model.Contact;
import com.example.springskillboxpractice3.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public String listContacts(Model model) { //model это объект, который позволяет передать данные из контроллера в HTML-шаблон
        model.addAttribute("contacts", contactService.getAllContacts()); // contacts имя атрибута, под которым
        // данные будут доступны в шаблоне.
        return "contacts"; //указывает на то, какой HTML-шаблон должен быть использован для отображения данных.(contacts.html)
    }

    @GetMapping("/add")
    public String showAddForm(Model model) { //model это объект, который позволяет передать данные из контроллера в HTML-шаблон
        model.addAttribute("contact", new Contact()); // contact имя атрибута, под которым
        // данные будут доступны в шаблоне.
        return "contact-form"; //указывает на то, какой HTML-шаблон должен быть использован для отображения данных.(contacts.html)
    }

    @PostMapping //обрабатывает POST-запрос, отправленный из формы
    public String addContact(@ModelAttribute Contact contact) { // @ModelAttribute Contact contact: связывает данные, которые пользователь отправил через форму, с объектом Contact
        contactService.addContact(contact);
        return "redirect:/contacts"; //после добавления перенаправляет пользователя на страницу со списком всех контактов
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "contact-form";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute Contact contact) {
        contactService.updateContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }
}
