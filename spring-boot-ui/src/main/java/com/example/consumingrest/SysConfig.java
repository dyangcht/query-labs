package com.example.consumingrest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SysConfig {

    @Value("${db.server.name:people}")
    private String host;

    @Value("${db.port:5432}") // Using the symbol「:」as default value
    private int port;

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
