package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountLink extends AbstractComponent {

    public MyAccountLink(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='My Account']")
    private WebElement myAccountLink;

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.myAccountLink.isDisplayed());
    }
}
