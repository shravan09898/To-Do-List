package org.shravan.todo.controller;


import org.shravan.todo.model.ToDoItem;
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
    public ToDoItem createTodoItem(@RequestBody ToDoItem newTask){
        return service.createTodoItem(newTask);
    }

    @GetMapping("/todo/{id}")
    public Optional<ToDoItem> getItemById(@PathVariable Long id){
        return service.getItemById(id);
    }

    @PutMapping("/todo")
    public ToDoItem updateItem(@RequestBody ToDoItem updateItem){
        return service.updateItem(updateItem);
    }

    @DeleteMapping("/todo/{id}")
    public boolean deleteItem(@PathVariable Long id){
        return service.deleteItem(id);
    }
    @DeleteMapping("/todo")
    public void deleteMultipleItems(@RequestBody List<Long> ids){

        service.deleteMultipleItems(ids);
    }

    @PutMapping("/updateStatus")
    public Optional<ToDoItem> updateStatusOfTask(@RequestBody ToDoItem item){

        return service.updateStatus(item);
    }
}
