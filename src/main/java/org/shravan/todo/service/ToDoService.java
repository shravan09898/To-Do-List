package org.shravan.todo.service;

import org.shravan.todo.model.ToDoItem;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface ToDoService {
    public List<ToDoItem> getAllTodoDetails();
    public ToDoItem createTodoItem();
    public ToDoItem getItemById(int id);
    public ToDoItem updateItem(ToDoItem toDoItem);
    public List<ToDoItem> deleteItem(long id);
    public List<ToDoItem> deleteMultipleItems();
    public ToDoItem updateStatus();

}
