package com.example.sample_3a.api.form;

import com.example.sample_3a.api.exception.InvalidParameterException;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

/**
 * @since       2020.03.28
 * @author      pollra
 * @description TodoForm
 **********************************************************************************************************************/
public class TodoForm {
    public static class Request {

        @Data
        @Builder
        public static class Add {
            private String title;
            private String content;

            public void validation() throws InvalidParameterException {
                try {
                    Objects.requireNonNull(this.title);
                    Objects.requireNonNull(this.content);
                } catch(Exception e) {
                    throw new InvalidParameterException("입력값을 다시 확인해주세요");
                }
            }
        }

        @Data
        @Builder
        public static class Modify {
            private String id;
            private String title;
            private String content;

            public void validation() throws InvalidParameterException {
                try {
                    Objects.requireNonNull(this.id);
                    Objects.requireNonNull(this.title);
                    Objects.requireNonNull(this.content);
                } catch(Exception e) {
                    throw new InvalidParameterException("입력값을 다시 확인해주세요");
                }
            }
        }

    }
}
