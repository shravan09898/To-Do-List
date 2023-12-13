package org.shravan.todo.service;

import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.model.response.GenericResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToDoService {
    List<ToDoItem> getAllTodoDetails();
    ToDoItem createTodoItem(ToDoItem item);
    Optional<ToDoItem> getItemById(UUID id);
    void updateItem(ToDoItem toDoItem);
    void deleteItem(UUID id);
    GenericResponse<String, String> deleteMultipleItems(List<UUID> ids);
    void updateStatus(ToDoItem item);

}
