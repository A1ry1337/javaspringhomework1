package com.example.spring_skillbox_practice4;

import com.example.spring_skillbox_practice4.dto.AccountUserDTO;
import com.example.spring_skillbox_practice4.model.AccountUser;
import com.example.spring_skillbox_practice4.service.AccountUserService;
import com.example.spring_skillbox_practice4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
// implements CommandLineRunner
public class SpringSkillboxPractice4Application implements CommandLineRunner{

	@Autowired
	private AccountUserService accountUserService;

	public static void main(String[] args) {
		SpringApplication.run(SpringSkillboxPractice4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
