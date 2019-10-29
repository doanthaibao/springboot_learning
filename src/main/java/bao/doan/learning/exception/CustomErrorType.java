package bao.doan.learning.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class CustomErrorType implements Serializable {
    private int statusCode;
    private String message;
}
