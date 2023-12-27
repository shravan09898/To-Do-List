package org.shravan.todo.model;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ToDoItem {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) UUID id;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private Date createdDate;
    private Date deadLine;
}
