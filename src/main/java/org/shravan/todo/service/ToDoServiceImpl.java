package org.shravan.todo.service;

import org.shravan.todo.exception.ItemNotFoundException;
import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.model.response.GenericResponse;
import org.shravan.todo.model.response.ResponseStatus;
import org.shravan.todo.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;

import static org.shravan.todo.model.response.ResponseStatus.*;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoItemRepository repository;
    public List<ToDoItem> getAllTodoDetails() {
        return repository.findAll();
    }
    public ToDoItem createTodoItem(@RequestBody ToDoItem item) {
        return repository.save(item);
    }
    @Override
    public Optional<ToDoItem> getItemById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void updateItem(@RequestBody ToDoItem toDoItem) {
        if (null == toDoItem.getId()) {
            throw new IllegalArgumentException("id cannot be empty");
        }
        ToDoItem existingItem = getItemById(toDoItem.getId())
                .orElseThrow(() -> new ItemNotFoundException("Item not available to delete with id: " + toDoItem.getId()));

        existingItem.setDescription(toDoItem.getDescription());
        existingItem.setCompleted(toDoItem.isCompleted());
        existingItem.setDeadLine(toDoItem.getDeadLine());
    }

    @Override
    public void deleteItem(@PathVariable UUID id) {
        if (!repository.existsById(id)) {
            throw new ItemNotFoundException("Item not available to delete with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public GenericResponse<String, String> deleteMultipleItems(List<UUID> ids) {
        Set<UUID> dbItems = repository.findAllById(ids)
                .stream().map(ToDoItem::getId)
                .collect(Collectors.toSet());
        List<String> errorList = new ArrayList<>();
        ids.forEach(id -> {
            if (!dbItems.contains(id)) {
                errorList.add("Item not available to delete with id: " + id);
                return;
            }
            repository.deleteById(id);
        });
        ResponseStatus responseStatus = SUCCESS;
        String message = "Items deleted successfully.";
        if (!CollectionUtils.isEmpty(errorList)) {
            if (ids.size() == errorList.size()) {
                responseStatus = FAILURE;
                message = "Failed to delete Items";
            } else {
                responseStatus = PARTIAL_SUCCESS;
                message = "Some Items are deleted successfully";
            }
        }
        return GenericResponse.<String, String>builder()
                .status(responseStatus)
                .message(message)
                .errorList(errorList)
                .build();
    }

    @Override
    public void updateStatus(@RequestBody ToDoItem toDoItem) {
        ToDoItem item = getItemById(toDoItem.getId())
                .orElseThrow(() -> new ItemNotFoundException("Item not available to delete with id: " + toDoItem.getId()));
        item.setCompleted(toDoItem.isCompleted());
        repository.save(item);
    }
}
