package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.edge.EdgeDriver;

public class HelloController {
    @FXML
    private Label welcomeText;
    private String profileDir = "F:\\New folder (2)";
    private String webdrive_location = "D:\\Gamig\\gamig\\gamig\\src\\main\\resources\\msedgedriver.exe";

    @FXML
    protected void onHelloButtonClick() {
        System.setProperty("webdriver.edge.driver", webdrive_location);

        welcomeText.setText("Welcome to JavaFX Application!");
        Credentials credentials = new Credentials(
                "1", "1",
                "1", "1",
                "50.114.84.87", "50100", "proxy_username", "proxy_password");

        Selenium selenium = new Selenium( profileDir+ credentials.username);
        EdgeDriver driver = selenium.initDriverWithProxy(credentials);
        driver.register(UsernameAndPassword.of(credentials.username, credentials.password));
    }
}