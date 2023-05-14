package com.spring.crud.api.backend.listners;

import com.spring.crud.api.backend.model.User;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

public class UserListener {

    @PrePersist
    public void prePersist(User user) {
        Date now = new Date();
        user.setCreated_at(now);
        user.setUpdated_at(now);
    }

    @PreUpdate
    public void preUpdate(User user) {
        user.setUpdated_at(new Date());
    }
}
