package com.glenndimaliwat.app.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    public NotificationServiceImpl() {
    }

    @Override
    public String send() {
        System.out.println("NotificationServiceImpl: inside send()");
        return "This is the send() service";
    }

    @Override
    public String sendAsync() {
        System.out.println("NotificationServiceImpl: inside sendAsync()");
        return "This is the sendAsync() service";
    }

    @Override
    public String toString() {
        return "NotificationServiceImpl{}";
    }
}
