package com.spring.crud.api.backend.repository;

import com.spring.crud.api.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
