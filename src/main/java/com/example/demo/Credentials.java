package com.example.demo;

public class Credentials {
    public final String username;
    public final String password;
    public final String email;
    public final String emailPassword;
    public final String proxy;
    public final String proxyPort;
    public final String proxyUsername;
    public final String proxyPassword;

    public Credentials(String username, String password, String email, String emailPassword,
                       String proxy, String proxyPort, String proxyUsername, String proxyPassword) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.emailPassword = emailPassword;
        this.proxy = proxy;
        this.proxyPort = proxyPort;
        this.proxyUsername = proxyUsername;
        this.proxyPassword = proxyPassword;
    }
}