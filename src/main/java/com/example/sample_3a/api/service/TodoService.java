package com.example.sample_3a.api.service;

import com.example.sample_3a.api.entity.Todo;
import com.example.sample_3a.api.repository.TodoRepository;

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

    public String write(Todo writeRequest) throws Exception{
        return todoRepository.save(writeRequest).getId();
    }
}
