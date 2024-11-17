package com.example.spring_skillbox_practice7.security;

import com.example.spring_skillbox_practice7.model.User;
import com.example.spring_skillbox_practice7.repository.UserRepository;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomUserDetailsService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> (UserDetails) new CustomUserDetails(user)) // Приведение типа к UserDetails
                .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")));
    }

}

