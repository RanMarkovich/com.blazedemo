package com.browserstack.Tests;


import com.browserstack.PageObject.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class TestLogin{
    private WebDriver driver;
    private Login login;

    @Before
    public void setUp(){
        this.driver = new ChromeDriver();
        this.login = new Login(driver);
    }

    @Test
    public void performLogin(){
        login.userInfo("ranm@yopmail.com","123456");
        assertEquals("You are logged in!", login.getSuccessMessageText());
    }

    @After
    public void TearDown(){
        driver.quit();
    }


}