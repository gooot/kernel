package com.example.exception.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello() {
        throw new RuntimeException("number format exception");
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity numberFormatException(
            NumberFormatException e
    ) {
        log.error("RestApiBController.numberFormatException", e);
        return ResponseEntity.ok().build();
    }
}
