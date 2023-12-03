package com.example.demo;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium {
    private final String profileDir;

    public Selenium(String profileDir) {
        this.profileDir = profileDir;
    }

    private void addDefaultsArguments(EdgeOptions options) {
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-allow-origins=*");
//        addProfileArg(options, profileDir, profileName);
    }

    private void initNewProfile() {

    }

    private void addProfileArg(EdgeOptions options, String profileDir) {
        options.addArguments("user-data-dir=" + profileDir);

    }

    public EdgeOptions initOptions(Proxy proxy) {
        EdgeOptions options = new EdgeOptions();
        addDefaultsArguments(options);
        options.setCapability("proxy", proxy);

        return options;
    }

    public EdgeOptions initOptions() {
        EdgeOptions options = new EdgeOptions();
        addDefaultsArguments(options);
        addProfileArg(options, profileDir);
        return options;
    }

    private EdgeOptions initOptionsWithProxy(Credentials credential) {
        EdgeOptions options = initOptions();
        Proxy proxy = initProxy(credential.proxy, Integer.parseInt(credential.proxyPort));
        options.setProxy(proxy);
        return options;
    }

    public Proxy initProxy(String proxyAddress, int proxyPort) {
        Proxy proxy = new Proxy();

        proxy.setSslProxy(proxyAddress + ":" + proxyPort);
        proxy.setHttpProxy(proxyAddress + ":" + proxyPort);
        proxy.setFtpProxy(proxyAddress + ":" + proxyPort);
        return proxy;
    }

    public EdgeDriver initDriver() {
        EdgeOptions options = initOptions();
        EdgeDriver driver = new EdgeDriver(options);
        return driver;
    }

    public EdgeDriver initDriverWithProxy(Credentials credential) {
        EdgeOptions options = initOptionsWithProxy(credential);
        EdgeDriver driver = new EdgeDriver(options);
        driver.register(UsernameAndPassword.of(credential.username, credential.password));
        return driver;
    }
}
