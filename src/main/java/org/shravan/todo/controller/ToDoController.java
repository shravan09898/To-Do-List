package org.shravan.todo.controller;


import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.repository.ToDoItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private ToDoItemRepository repository;

    public ToDoController(ToDoItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todo")
    public List<ToDoItem> getAllTodoDetails(){
        return repository.findAll();
    }

    @PostMapping("/todo")
    public ToDoItem createTodoItem(@RequestBody ToDoItem newTask){

        return repository.save(newTask);
    }

    @GetMapping("/todo/{id}")
    public ToDoItem getItemById(long id){
        return null;
    }

    @PutMapping("/todo")
    public ToDoItem updateItem(ToDoItem toDoItem){
        return null;
    }

    @DeleteMapping("/todo/{id}")
    public List<ToDoItem> deleteItem(long id){
        return null;
    }
    @DeleteMapping("/todo")
    public List<ToDoItem> deleteMultipleItems(){
        return null;
    }
//    @PutMapping("/todo")
//    public ToDoItem updateStatus(){
//        return null;
//    }
}
