package com.juaracoding;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Saucedemo {
    public static void main(String[] args) {
        String path = "C:\\juaracoding\\sqabach12\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Open Browser");

        // Login Function
        // Test Case Positive
        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
        // Step Validation
        WebElement txtDashboard = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]"));
        String getTxtDashboard = txtDashboard.getText();
        if (getTxtDashboard.equals("Dashboard")) {
            System.out.printf("Passes");
        } else {
            System.out.printf("Failed");
        }

        // Test Case Negative
        WebElement btnProfile = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div"));
        WebElement btnLogout = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        btnProfile.click();
        btnLogout.click();
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
        // Step Validation
        WebElement txtInvalid = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[2]"));
        String getTxtInvalid = txtInvalid.getText();
        if(getTxtDashboard.equals("Invalid credentials")){
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }
    }
}
