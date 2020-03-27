package com.example.sample_3a.api.repository;

import com.example.sample_3a.api.entity.Todo;
import com.example.sample_3a.api.form.TodoForm.Request;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @since       2020.03.28
 * @author      pollra
 * @description TodoRepository
 **********************************************************************************************************************/
@Repository
public interface TodoRepository {
    Todo add(Todo form);
    String modify(Todo entity);
    Optional<Todo> find(String anyString);
}
