package com.example.sample_3a.api;

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

    public Todo write(Todo writeRequest) {

        return todoRepository.save(writeRequest);
    }
}
