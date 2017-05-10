package com.glenndimaliwat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    DatabaseService databaseService;

    @RequestMapping("/")
    public String showHomepage() {
        return "<a href=\"/message\">Click to see the Message</a><br/>";
    }

    @RequestMapping("/message")
    public String showMessage() {
        return homeService.generateMessage() + "<br/><br/><a href=\"/database\">Show Database Credentials</a>";
    }

    @RequestMapping("/database")
    public String showDatabase() {
        return databaseService.getConnectionCredentials();
    }
}
