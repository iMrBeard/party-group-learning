package com.learning.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private boolean success;
    private Long ts = System.currentTimeMillis();
    private T data;
    private String message;

    public static Result ofSuccess(String message){
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    public static Result ofSuccess(String message,Object data){
        Result result = new Result();
        result.success = true;
        result.message = message;
        result.setData(data);
        return result;
    }

    public static Result ofFail(String message){
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }
}
