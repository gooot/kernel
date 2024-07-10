package com.example.restapi.controller;


import com.example.restapi.model.BookQueryParam;
import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public BookRequest post(
            @RequestBody BookRequest bookrequest
            ){
        System.out.println(bookrequest);

        return bookrequest;
    }
    @PostMapping("/user")
    public void User(
            @RequestBody UserRequest userRequest
            ){
        System.out.println(userRequest);

    }
}



