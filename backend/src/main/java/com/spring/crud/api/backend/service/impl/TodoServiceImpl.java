package com.spring.crud.api.backend.service.impl;

import com.spring.crud.api.backend.exception.ResourceNotFoundException;
import com.spring.crud.api.backend.model.Todo;
import com.spring.crud.api.backend.repository.TodoRepository;
import com.spring.crud.api.backend.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo", "Id", id));
    }

    @Override
    public Todo updateTodo(Todo todo, long id) {
        Todo existingTodo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo", "Id", id));
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        todoRepository.save(existingTodo);
        return existingTodo;
    }

    @Override
    public void deleteTodo(long id) {
        todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo", "Id", id));
        todoRepository.deleteById(id);
    }
}
