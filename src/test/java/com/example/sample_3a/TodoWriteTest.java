package com.example.sample_3a;

import com.example.sample_3a.api.Todo;
import com.example.sample_3a.api.TodoRepository;
import com.example.sample_3a.api.TodoService;
import com.example.sample_3a.api.exception.InvalidParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/**
 * @since       2020.03.28
 * @author      pollra
 * @description TodoWriteTest
 **********************************************************************************************************************/
public class TodoWriteTest {
    @Mock
    private TodoRepository todoRepository;

    private TodoService todoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        todoService = new TodoService(todoRepository);
    }

    @Test
    void 정상적인_요청으로_TODO_작성_요청을_수행함(){
        // arrange : 객체 선언
        final Todo request = Todo.builder()
                .title("정상적인")
                .content("데이터")
                .build();
        final Todo response = Todo.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        // stubbing
        when(todoRepository.save(any(Todo.class)))
                .thenReturn(response);
        // act : 행동
        final String todoId = todoService.write(request);
        // assert : 원하는 결과
        assertNotEquals("", todoId);
        assertNotEquals(null, todoId);
    }

    @Test
    void 비정상적인_파라미터로_요청을_받은_경우_InvalidParameterException이_발생() {
        // arrange : 객체 선언
        final Todo request = Todo.builder().build();

        Assertions.assertThrows(
                InvalidParameterException.class,    // assert : 원하는 결과
                () -> todoService.write(request)    // act    : 행동
        );
    }


}
