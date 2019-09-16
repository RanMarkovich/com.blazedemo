package com.browserstack.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsFinder {
    private WebDriver driver;
    private Select dropDown;
    private WebDriverWait wait;
    private By fromLocationLocator = By.name("fromPort");
    private By toLocationLocator = By.name("toPort");
    private By flightsTableLocator = By.className("table");


    public FlightsFinder(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.get("http://blazedemo.com/");
    }

    public void selectFromAndTo(String fromLocation, String toLocation) {
        dropDown = new Select(driver.findElement(fromLocationLocator));
        dropDown.selectByVisibleText(fromLocation);
        dropDown = new Select(driver.findElement(toLocationLocator));
        dropDown.selectByVisibleText(toLocation);
        driver.findElement(toLocationLocator).submit();
    }

    public boolean isFlightsTablePresent() {
        wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flightsTableLocator)).isDisplayed();
    }

}
