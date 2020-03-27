package com.example.sample_3a.api;

import org.springframework.stereotype.Repository;

/**
 * @since       2020.03.28
 * @author      pollra
 * @description TodoRepository
 **********************************************************************************************************************/
@Repository
public interface TodoRepository {
    Todo save(Todo entity);
}
