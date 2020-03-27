package com.example.sample_3a.api.service;

import com.example.sample_3a.api.entity.Todo;
import com.example.sample_3a.api.exception.InvalidParameterException;
import com.example.sample_3a.api.exception.TodoNotFoundException;
import com.example.sample_3a.api.form.TodoForm.Request;
import com.example.sample_3a.api.repository.TodoRepository;

import java.util.Optional;

/**
 * @since       2020.03.28
 * @author      pollra
 * @description TodoService
 **********************************************************************************************************************/
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public String add(Request.Add request) throws Exception{
        request.validation();
        final Todo todo = Todo.builder()
                .id(request.getTitle())
                .content(request.getContent())
                .build();
        return todoRepository.add(todo).getId();
    }

    public String modify(Request.Modify modify) throws TodoNotFoundException, InvalidParameterException {
        modify.validation();
        final Todo todo = todoRepository
                .find(modify.getId())
                .orElseThrow(()-> new TodoNotFoundException("해당 키를 가진 Todo 데이터가 존재하지 않습니다"));
        todo.update(modify);
        return todoRepository.modify(todo);
    }
}
