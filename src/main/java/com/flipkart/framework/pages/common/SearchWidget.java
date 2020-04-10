package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent {

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    public void enter(String keyword) {
        this.searchBox.clear();

        /*
        Sending one char at a time to demonstrate real use behaviour
        while using a search functionality.
         */
        for (char c : keyword.toCharArray()) {
            this.searchBox.sendKeys(c + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.searchBox.isDisplayed());
    }
}
