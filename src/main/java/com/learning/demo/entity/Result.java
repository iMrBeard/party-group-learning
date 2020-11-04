package com.learning.demo.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("统一返回结果")
public class Result<T> implements Serializable {

    private boolean success;
    private Long ts = System.currentTimeMillis();
    private String message;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public static Result ofSuccess(String message, Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result ofSuccess(String message) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    public static Result ofFail(String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }
}
