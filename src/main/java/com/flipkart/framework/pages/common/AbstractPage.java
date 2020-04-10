package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public abstract class AbstractPage {

    public WebDriver driver;

    public AbstractPage(final WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(String url) {
        this.driver.get(url);
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

    public void closeCurrentWindow() {
        this.driver.close();
    }

}
