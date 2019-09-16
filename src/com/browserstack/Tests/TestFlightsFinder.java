package com.browserstack.Tests;

import com.browserstack.PageObject.FlightsFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestFlightsFinder {
    WebDriver driver;
    FlightsFinder flightFinder;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        this.flightFinder = new FlightsFinder(driver);
    }

    @Test
    public void findFlight() {
        flightFinder.selectFromAndTo("Boston", "Rome");
        assertTrue("Flight table not present", flightFinder.isFlightsTablePresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
