package com.example.spring_skillbox_practice4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @OneToMany(mappedBy = "author")
    private List<News> news;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    @Override
    public String toString() {
        return "AccountUserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}