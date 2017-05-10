package com.glenndimaliwat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Value("${app.messageFromProperties}")
    private String messageFromProperties;

    @Value("${app.messageFromYaml}")
    private String messageFromYaml;

    public String generateMessage() {

        String message = "This is a hidden message <br/>"
                        + "Properties: " + messageFromProperties + "<br/>"
                        + "Yaml: " + messageFromYaml;

        return message;
    }
}
