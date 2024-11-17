package com.example.spring_skillbox_practice5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringSkillboxPractice5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSkillboxPractice5Application.class, args);
	}

}
