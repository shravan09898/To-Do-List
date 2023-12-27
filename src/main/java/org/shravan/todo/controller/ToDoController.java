package org.shravan.todo.controller;


import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity getAllTodoDetails(){
        List<ToDoItem> list = service.getAllTodoDetails();
        return ResponseEntity.ok(list);
    }

    //ResponseEntity with headers example
    @GetMapping("/customHeader")
    ResponseEntity<String> customHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return new ResponseEntity<>(
                "Custom header set", headers, HttpStatus.OK);
    }
    @PostMapping("/todo")
    public ResponseEntity createTodoItem(@RequestBody ToDoItem newTask){
        ToDoItem toDoItem = service.createTodoItem(newTask);
        return ResponseEntity.ok(toDoItem);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity getItemById(@PathVariable UUID id){
        Optional<ToDoItem> toDoItem = service.getItemById(id);
        return ResponseEntity.ok(toDoItem);
    }

    @PutMapping("/todo")
    public ResponseEntity updateItem(@RequestBody ToDoItem updateItem){
        service.updateItem(updateItem);
        return ResponseEntity.ok("Update Done");
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity deleteItem(@PathVariable UUID id){
        boolean isTrue = service.deleteItem(id);
        return ResponseEntity.ok(isTrue);
    }
    @DeleteMapping("/todo")
    public ResponseEntity deleteMultipleItems(@RequestBody List<UUID> ids){
        service.deleteMultipleItems(ids);
        return ResponseEntity.ok("Delete Done");
    }

    @PutMapping("/updateStatus")
    public ResponseEntity updateStatusOfTask(@RequestBody ToDoItem item){
        Optional<ToDoItem> updatedItem = service.updateStatus(item);
        return ResponseEntity.ok(updatedItem);
    }
}
