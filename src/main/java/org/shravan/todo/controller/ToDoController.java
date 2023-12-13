package org.shravan.todo.controller;


import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.model.response.GenericResponse;
import org.shravan.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ToDoController{

    @Autowired
    private ToDoService service;

    @GetMapping("/todo")
    public List<ToDoItem> getAllTodoDetails(){
        return service.getAllTodoDetails();
    }

    @PostMapping("/todo")
    public ToDoItem createTodoItem(@RequestBody ToDoItem newTask){
        return service.createTodoItem(newTask);
    }

    @GetMapping("/todo/{id}")
    public Optional<ToDoItem> getItemById(@PathVariable UUID id){
        return service.getItemById(id);
    }

    @PutMapping("/todo")
    public void updateItem(@RequestBody ToDoItem updateItem){
        service.updateItem(updateItem);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteItem(@PathVariable UUID id){
        service.deleteItem(id);
    }
    @DeleteMapping("/todo")
    public ResponseEntity<GenericResponse<String, String>> deleteMultipleItems(@RequestBody List<UUID> ids){
        return ResponseEntity.ok(service.deleteMultipleItems(ids));
    }

    @PutMapping("/updateStatus")
    public void updateStatusOfTask(@RequestBody ToDoItem item){
        service.updateStatus(item);
    }
}
