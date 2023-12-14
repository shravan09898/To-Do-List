package org.shravan.todo.service;

import org.shravan.todo.model.ToDoItem;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    public List<ToDoItem> getAllTodoDetails();
    public ToDoItem createTodoItem(ToDoItem item);
    public Optional<ToDoItem> getItemById(Long id);
    public ToDoItem updateItem(ToDoItem toDoItem);
    public boolean deleteItem(Long id);
    public void deleteMultipleItems(List<Long> ids);
    public Optional<ToDoItem> updateStatus(ToDoItem item);

}
