package com.spring.crud.api.backend.controller;

import com.spring.crud.api.backend.model.Todo;
import com.spring.crud.api.backend.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
public class TodoController {
//    @Autowired // not needed here because we are using constructor injection here
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo){
        return new ResponseEntity<Todo>(todoService.saveTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") long todoId) {
        return new ResponseEntity<Todo>(todoService.getTodoById(todoId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") long todoId, @RequestBody Todo todo){
        return new ResponseEntity<Todo>(todoService.updateTodo(todo, todoId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") long id){
        todoService.deleteTodo(id);
        return new ResponseEntity<String>("Todo deleted Successfully", HttpStatus.OK);
    }

}
