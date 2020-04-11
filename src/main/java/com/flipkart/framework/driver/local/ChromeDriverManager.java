package com.flipkart.framework.driver.local;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    protected ChromeDriverService chromeDriverService;

    @Override
    protected void startService() {
        try {
            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("/Users/punarjitsingh/drivers/chromedriver"))
                    .usingAnyFreePort()
                    .build();
            chromeDriverService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void stopService() {
        if(null != chromeDriverService && chromeDriverService.isRunning()) {
            chromeDriverService.stop();
            chromeDriverService = null;
        }
    }

    @Override
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        driver = new ChromeDriver(chromeDriverService, options);
    }
}
