package org.shravan.todo.repository;

import org.shravan.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, UUID> {

}
