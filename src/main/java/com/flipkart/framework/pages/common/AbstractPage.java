package com.flipkart.framework.pages.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public abstract class AbstractPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void goTo(String url) {
        this.driver.get(url);
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public String getWinHandle() {
        return this.driver.getWindowHandle();
    }

    public Set<String> getWinHandles() {
        return this.driver.getWindowHandles();
    }

    /**
     * Switch to the last open window using a set of current window handles
     */
    public void switchToWindow(Set<String> winHandles) {
        for(String winHandle : winHandles){
            this.driver.switchTo().window(winHandle);
        }
    }

    /**
     * Switch to a window using a window handle
     */
    public void switchToWindow(String winHandle) {
        this.driver.switchTo().window(winHandle);
    }

    /**
     * Close current active window
     */
    public void closeCurrentWindow() {
        this.driver.close();
    }

}
