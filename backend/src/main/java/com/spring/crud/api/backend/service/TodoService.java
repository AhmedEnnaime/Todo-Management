package com.spring.crud.api.backend.service;

import com.spring.crud.api.backend.model.Todo;

import java.util.List;

public interface TodoService {
    Todo saveTodo(Todo todo);
    List<Todo> getAllTodos();
    Todo getTodoById(long id);
    Todo updateTodo(Todo todo,long id);
    void deleteTodo(long id);
}
