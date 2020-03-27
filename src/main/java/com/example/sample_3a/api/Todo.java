package com.example.sample_3a.api;

import com.example.sample_3a.api.exception.InvalidParameterException;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

/**
 * @since       2020.03.28
 * @author      pollra
 * @description Todo
 **********************************************************************************************************************/
@Data
public class Todo {

    private String id = UUID.randomUUID().toString();
    private String title;
    private String content;

    @Builder
    public Todo(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
