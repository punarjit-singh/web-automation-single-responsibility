package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLink  extends AbstractComponent {

    public LoginLink(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(css = "[class*='_1XBjg']")
    private WebElement loginWidget;

    public void click() {
        this.loginLink.click();
        this.wait.until((driver) -> this.loginWidget.isDisplayed());
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.loginLink.isDisplayed());
    }
}
