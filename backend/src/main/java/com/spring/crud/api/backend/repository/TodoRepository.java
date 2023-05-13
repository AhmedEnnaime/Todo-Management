package com.spring.crud.api.backend.repository;

import com.spring.crud.api.backend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
