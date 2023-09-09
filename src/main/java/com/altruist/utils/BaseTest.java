package com.altruist.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * WebDriver setup and teardown for tests.
 */
public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(Constants.urlStockPage);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.durationSeconds));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
