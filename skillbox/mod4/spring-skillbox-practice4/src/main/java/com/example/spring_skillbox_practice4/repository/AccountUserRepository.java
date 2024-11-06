package com.example.spring_skillbox_practice4.repository;

import com.example.spring_skillbox_practice4.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {
}
