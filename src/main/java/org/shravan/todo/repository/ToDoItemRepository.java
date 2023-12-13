package org.shravan.todo.repository;

import org.shravan.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, UUID> {

    boolean existsById(UUID id);

}
