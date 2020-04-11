package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginWidget extends AbstractComponent {

    public LoginWidget(final WebDriver driver) {
        super(driver);
    }

    /**
     * More login related Web elements and methods can be added here.
     * e.g. Link - "New to Flipkart? Create an account" or "Forgot?" link and so on
     * For the purpose of this assignment only the required elements and methods are added
     */

    @FindBy(css = "[class*='_39M2dM'] input:not([class*='_3v41xv'])")
    private WebElement emailInput;

    @FindBy(css = "[class*='_39M2dM'] input[class*='_3v41xv']")
    private WebElement passwordInput;

    @FindBy(css = "._1avdGP button")
    private WebElement loginButton;

    @FindBy(css = "[class*='dImZt_']")
    private List<WebElement> heroImagesOnLoad;

    public void login(String username, String password) {
        this.emailInput.clear();
        this.emailInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }

    /**
     * Just adding a skeleton to demonstrate that all functionality
     * related to login widget must sit in this class
     * for example the creatAccount method can accept some
     * @data arguments and create an account on flipkart.com
     * public void createAccount() {
     * }
    */

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.emailInput.isDisplayed());
    }
}
