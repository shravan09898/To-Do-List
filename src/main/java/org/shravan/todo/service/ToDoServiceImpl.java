package org.shravan.todo.service;

import org.shravan.todo.exception.ItemNotFoundException;
import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    public ToDoItem getItemById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not available with id: "+id));
    }

    //PENDING
    @Override
    public ToDoItem updateItem(@RequestBody ToDoItem toDoItem) {
        return null;
    }

    @Override
    public boolean deleteItem(@PathVariable Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
        else{
            throw new ItemNotFoundException("Item not available to delete with id: "+id);
        }
        return true;
    }

    @Override
    public List<ToDoItem> deleteMultipleItems() {
        return null;
    }

    @Override
    public ToDoItem updateStatus() {
        return null;
    }
}
