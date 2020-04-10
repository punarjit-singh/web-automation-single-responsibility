package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWidget extends AbstractComponent {

    public LoginWidget(final WebDriver driver) {
        super(driver);
    }

    /**
     * More login related Web elements and methods can be added here.
     * For the purpose of this assignment only the required items are added.
     */

    @FindBy(css = "[class*='_39M2dM'] input:not([class*='_3v41xv'])")
    private WebElement emailInput;

    @FindBy(css = "[class*='_39M2dM'] input[class*='_3v41xv']")
    private WebElement passwordInput;

    @FindBy(css = "._1avdGP button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[text()='My Account']")
    private WebElement myAccountLink;

    public void login(String username, String password) {
        this.emailInput.clear();
        this.emailInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
        this.wait.until((driver) -> this.myAccountLink.isDisplayed());
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.emailInput.isDisplayed());
    }
}
