package com.browserstack.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertEquals;


public class Login {
    private WebDriver driver;
    private By loginHeaderLocator = By.className("panel-heading");
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By rememberMeLocator = By.name("remember");
    private By successMessageLocator = By.className("panel-body");
    private WebDriverWait wait;

    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
        driver.get("http://blazedemo.com/login");
        assertEquals("Login", wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeaderLocator)).getText());
    }

    public void userInfo(String emailAddress, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator)).sendKeys(emailAddress);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(rememberMeLocator).click();
        driver.findElement(rememberMeLocator).submit();
    }

    public String getSuccessMessageText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator)).getText();
    }
}