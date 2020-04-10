package com.flipkart.test.base;

import org.openqa.selenium.WebDriver;
import com.flipkart.framework.driver.DriverManager;
import com.flipkart.framework.driver.DriverManagerFactory;
import com.flipkart.framework.driver.DriverType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    protected DriverManager driverManager;

    @BeforeTest
    public void setupDriver () {
        this.driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        this.driver = this.driverManager.getDriver();
    }

    @AfterTest
    public void quitDriver() {
        this.driverManager.quitDriver();
    }
}
