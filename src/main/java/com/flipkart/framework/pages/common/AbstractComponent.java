package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriverWait wait;

    public AbstractComponent(final WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        PageFactory.initElements(driver, this);
    }

    protected abstract boolean isDisplayed();
}
