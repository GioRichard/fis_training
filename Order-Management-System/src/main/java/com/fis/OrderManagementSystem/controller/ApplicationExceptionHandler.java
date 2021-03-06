package com.fis.OrderManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.fis.OrderManagementSystem.constant.Constant.INTERNAL_SERVER_ERROR;
import static com.fis.OrderManagementSystem.constant.Constant.ORDER_NOT_FOUND;

public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            IllegalArgumentException.class
    })
    protected ResponseEntity<ErrorMessage> handleOrderNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().code(ORDER_NOT_FOUND).message(exception.getMessage()).build());
    }

    @ExceptionHandler(value = {
            Exception.class
    })
    protected ResponseEntity<ErrorMessage> handleSystemError(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorMessage.builder().code(INTERNAL_SERVER_ERROR).message(exception.getMessage()).build());
    }
}
