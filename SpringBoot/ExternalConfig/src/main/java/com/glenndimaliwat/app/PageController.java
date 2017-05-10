package com.glenndimaliwat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @Autowired
    Customer customer;

    @Value("${pageController.msg}")
    private String pageControllerMsg;

    @Value("${spring.profiles.active}")
    private String environment;

    @Value("${msg}")
    private String msg;

    @RequestMapping("/")
    public String home() {
        System.out.println(customer.toString());

        //return pageControllerMsg;

        //return environment;

        return msg;
    }

}
