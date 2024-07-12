package com.example.exception.exception;


import com.example.exception.controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
//@RestControllerAdvice(basePackages = "com.example.exception.controller")
@RestControllerAdvice(basePackageClasses = {RestController.class, RestApiController.class})
@Order(value = 1)
public class RestApiExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api> exception(
            Exception e
    ){
        log.error("",e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

/*
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(
            Exception e
    ) {
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();

    }
*/

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            Exception e
    ) {
        log.error("IndexOutOfBoundsException", e);
        return ResponseEntity.status(200).build();
    }
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity noSuchElement(
            NoSuchElementException e
    ){
        log.error("noSuchElementException", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.NOT_FOUND.name())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response)
                ;
    }
}
