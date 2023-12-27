package org.shravan.todo.service;

import org.shravan.todo.exception.ItemNotFoundException;
import org.shravan.todo.model.ToDoItem;
import org.shravan.todo.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<ToDoItem> getItemById(@PathVariable Long id) {
        if(!repository.existsById(id)){
            throw new ItemNotFoundException("Item not available with id: "+id);
        }
        return repository.findById(id);
    }

    //PENDING
    @Override
    public void updateItem(@RequestBody ToDoItem toDoItem) {
        if(toDoItem.getId()==null){
            throw new IllegalArgumentException("Id is not present in given input");
        }

        ToDoItem existingItem = repository.findById(toDoItem.getId())
                .orElseThrow(() -> new ItemNotFoundException("Item not available in DB with id: "+toDoItem.getId()));

        existingItem.setDescription(toDoItem.getDescription());
        existingItem.setStatus(toDoItem.getStatus());
        existingItem.setDeadLine(toDoItem.getDeadLine());

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
    public void deleteMultipleItems(@RequestBody List<Long> ids) {
        repository.deleteAllById(new ArrayList<>(ids));
    }

    @Override
    public Optional<ToDoItem> updateStatus(@RequestBody ToDoItem toDoItem) {
        Long id = toDoItem.getId();
        if(repository.existsById(id)){
            ToDoItem item = repository.findById(id).orElse(null);
            item.setStatus(toDoItem.getStatus());
            repository.save(item);
        }
        else{
            throw new ItemNotFoundException("Item not available to delete with id: "+id);
        }

        return repository.findById(id);
    }
}
