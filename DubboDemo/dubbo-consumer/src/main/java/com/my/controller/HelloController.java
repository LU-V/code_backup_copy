package com.my.controller;

import com.my.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {


    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        String result = helloService.hello("consumer params...");
        return result;
    }

}
