package com.flipkart.test.base;

import com.flipkart.framework.driver.CapabilityFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    /* Not in use when using grid
    protected DriverManager driverManager;
    */

    protected WebDriver driver;
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeTest
    @Parameters(value={"browser"})
    public void setupDriver (String browser) throws MalformedURLException {
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser));
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

    /*
     * The following two methods are for demo only
     * These can be used when testing on local to manage driver using the DriverManagerFactory

    public void setupDriver () {
        this.driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        this.localDriver = this.driverManager.getDriver();
    }

    public void quitDriver() {
        this.driverManager.quitDriver();
    }
    */
}
