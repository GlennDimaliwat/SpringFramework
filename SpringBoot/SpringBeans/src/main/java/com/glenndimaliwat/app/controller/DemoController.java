package com.glenndimaliwat.app.controller;

import com.glenndimaliwat.app.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping("/")
    public String home() {
        return "<a href=\"/NotificationSend\">Send</a><br/>" +
                "<a href=\"/NotificationSendAsync\">Send Async</a>" ;
    }

    @RequestMapping("/NotificationSend")
    public String sendNotification() {
        return notificationService.send();
    }

    @RequestMapping("/NotificationSendAsync")
    public String sendAsyncNotification() {
        return notificationService.sendAsync();
    }
}
