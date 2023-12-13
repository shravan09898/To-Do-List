package org.shravan.todo.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class TodoResponse {

    private UUID id;

    private String description;

    private boolean completed = false;

    private Date createdDate = new Date();

    private Date deadLine;

}
