package org.shravan.todo.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GenericResponse<D, E> {

    ResponseStatus status;

    String message;

    List<D> responseList;

    List<E> errorList;

}
