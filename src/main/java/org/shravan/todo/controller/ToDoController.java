package org.shravan.todo.controller;


import org.shravan.todo.exception.ItemNotFoundException;
import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.repository.ToDoItemRepository;
import org.shravan.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController{

    @Autowired
    private ToDoService service;

    @GetMapping("/todo")
    public List<ToDoItem> getAllTodoDetails(){
        return service.getAllTodoDetails();
    }

    @PostMapping("/todo")
    public ToDoItem createTodoItem(ToDoItem newTask){
        return service.createTodoItem(newTask);
    }

    @GetMapping("/todo/{id}")
    public ToDoItem getItemById(@PathVariable Long id){
        return service.getItemById(id);
    }

    @PutMapping("/todo/{id}")
    public void updateItem(ToDoItem updateItem, Long id){

    }

    @DeleteMapping("/todo/{id}")
    public List<ToDoItem> deleteItem(@PathVariable Long id){
        return service.deleteItem(id);
    }
    @DeleteMapping("/todo")
    public List<ToDoItem> deleteMultipleItems(){
        return null;
    }
}
