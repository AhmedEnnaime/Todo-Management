package com.spring.crud.api.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.crud.api.backend.listners.TodoListener;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
//import lombok.Data;

@Table(name = "todos")
@Entity
@EntityListeners(TodoListener.class)
//@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = true)
    private String description;

    @Column(nullable = false, updatable = false)
    private Date created_at;

    @Column(nullable = false)
    private Date updated_at;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    public Todo() {}

    public Todo(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
