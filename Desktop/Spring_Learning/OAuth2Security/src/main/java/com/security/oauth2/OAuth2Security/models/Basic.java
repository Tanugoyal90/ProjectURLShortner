package com.security.oauth2.OAuth2Security.models;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Basic {

    @GetMapping("/getHelloWorld")
    public String getHelloWorld(){
        return "Hello World!!";
    }
}
