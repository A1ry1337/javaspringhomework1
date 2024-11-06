package com.example.spring_skillbox_practice4.dto;

import com.example.spring_skillbox_practice4.model.Comment;
import com.example.spring_skillbox_practice4.model.News;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountUserDTO {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private List<NewsDTO> news;
    private List<CommentDTO> comments;
    @Override
    public String toString() {
        return "AccountUserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
