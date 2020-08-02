package com.learning.demo.util;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorsToMessage {
    public static String getMessage(Errors errors){
        List<FieldError> fieldErrors = errors.getFieldErrors();
        StringBuilder message = new StringBuilder();
        for(FieldError fieldError : fieldErrors){
            message.append(fieldError.getDefaultMessage());
        }
        return message.toString();
    }
}
