package com.example.sample_3a;

import com.example.sample_3a.api.entity.Todo;
import com.example.sample_3a.api.exception.TodoNotFoundException;
import com.example.sample_3a.api.form.TodoForm.Request;
import com.example.sample_3a.api.repository.TodoRepository;
import com.example.sample_3a.api.service.TodoService;
import com.example.sample_3a.api.exception.InvalidParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @since       2020.03.28
 * @author      pollra
 * @description TodoWriteTest
 **********************************************************************************************************************/
public class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;

    private TodoService todoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        todoService = new TodoService(todoRepository);
    }

    @Test
    void 정상적인_요청으로_TODO_작성_요청을_수행함() throws Exception {
        // arrange : 객체 선언
        final Request.Add request = Request.Add.builder()
                .title("정상적인")
                .content("데이터")
                .build();
        final Todo todo = Todo.builder()
                .id(UUID.randomUUID().toString())
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        // stubbing : mock 의 행동을 정의
        when(todoRepository.add(any(Todo.class)))
                .thenReturn(todo);

        // act : 행동
        final String todoId = todoService.add(request);

        // assert : 원하는 결과
        assertNotEquals("", todoId);
        assertNotEquals(null, todoId);
    }

    @Test
    void 비정상적인_파라미터로_요청을_받은_경우_InvalidParameterException이_발생(){
        // arrange : 객체 선언
        final Request.Add request = Request.Add.builder().build();

        Assertions.assertThrows(
                InvalidParameterException.class,    // assert : 원하는 결과
                () -> todoService.add(request)      // act    : 행동
        );
    }

    @Test
    void 존재하지_않는_TODO_수정_요청_일때_TodoNotFoundException () {
        // arrange : 객체 생성
        final Request.Modify request = Request.Modify.builder()
                .id(UUID.randomUUID().toString())
                .title("존재하지 않는 데이터의")
                .content("수정 요청")
                .build();

        // stubbing : mock 의 행동을 정의
        when(todoRepository.find(anyString()))
                .thenReturn(Optional.empty());

        assertThrows(
                TodoNotFoundException.class,        // assert : 원하는 결과
                ()-> todoService.modify(request)    // act    : 행동
        );
    }

    @Test
    void 비정상적인_파라미터로_수정_요청을_받은_경우_InvalidParameterException_발생() {
        // arrange : 객체 생성
        final Request.Modify request = Request.Modify.builder()
                .id(UUID.randomUUID().toString())
                .build();

        assertThrows(
                InvalidParameterException.class,    // assert : 원하는 결과
                ()-> todoService.modify(request)    // act    : 행동
        );
    }

}
