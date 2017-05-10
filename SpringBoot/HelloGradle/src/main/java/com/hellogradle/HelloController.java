package com.hellogradle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/Hello")
    public String home() {
        return "Hello Gradle!";
    }
}
