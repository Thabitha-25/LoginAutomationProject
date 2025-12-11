package com.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button.radius");
    By successMsg = By.cssSelector("div.flash.success");
    By errorMsg = By.cssSelector("div.flash.error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        System.out.println("Entered Username: " + user);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
        System.out.println("Entered Password: " + pwd);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
        System.out.println("Clicked Login Button");
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
