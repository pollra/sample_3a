package com.example.sample_3a.api.entity;

import com.example.sample_3a.api.exception.InvalidParameterException;
import com.example.sample_3a.api.form.TodoForm.Request;
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
    public Todo(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void validation() throws InvalidParameterException {
        try {
            Objects.requireNonNull(this.title);
            Objects.requireNonNull(this.content);
        }catch (Exception e) {
            throw new InvalidParameterException("NULL 값이 존재합니다");
        }
    }

    public void update(Request.Modify modify) {
        this.title = modify.getTitle();
        this.content = modify.getContent();
    }
}
