package com.spring.crud.api.backend.listners;

import com.spring.crud.api.backend.model.Todo;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

public class TodoListener {
    @PrePersist
    public void prePersist(Todo todo) {
        Date now = new Date();
        todo.setCreated_at(now);
        todo.setUpdated_at(now);
    }

    @PreUpdate
    public void preUpdate(Todo todo) {
        todo.setUpdated_at(new Date());
    }
}
