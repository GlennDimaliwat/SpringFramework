package com.glenndimaliwat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Value("${databaseUrl}")
    private String databaseUrl;

    @Value("${databaseUsername}")
    private String databaseUsername;

    @Value("${databasePassword}")
    private String databasePassword;


    public String getConnectionCredentials() {

        String credentials = databaseUrl + ":" + databaseUsername + ":" + databasePassword;

        return credentials;
    }
}
