package org.shravan.todo.service;

import org.shravan.todo.model.ToDoItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToDoService {
    public List<ToDoItem> getAllTodoDetails();
    public ToDoItem createTodoItem(ToDoItem item);
    public Optional<ToDoItem> getItemById(UUID id);
    public void updateItem(ToDoItem toDoItem);
    public boolean deleteItem(UUID id);
    public void deleteMultipleItems(List<UUID> ids);
    public Optional<ToDoItem> updateStatus(ToDoItem item);

}
