package com.example.spring_skillbox_practice4.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("firstPassword"));
        System.out.println(encoder.encode("secPassword"));
        System.out.println(encoder.encode("lolPassword"));
    }
}
