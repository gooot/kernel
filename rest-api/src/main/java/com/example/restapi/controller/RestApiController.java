package com.example.restapi.controller;


import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {



    @GetMapping(path="/hello")
    public String hello(){

        var html = "<html> <body> <h1> hello world</h1> </body></html> ";


        return html;
    }
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        msg=msg.toUpperCase();

        System.out.print("echo message : "+msg );
        System.out.println("echo age : " + age);
        System.out.println("echo isMan : " + isMan);
        return msg;

    }

    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued-day") String issuedDay

    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);

    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
           BookQueryParam bookQueryParam

    ) {
        System.out.println(bookQueryParam);


    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
    }
    )
    public void delete(
            @PathVariable String userName

    ) {
        log.info("user-name : {}", userName);

    }


}
