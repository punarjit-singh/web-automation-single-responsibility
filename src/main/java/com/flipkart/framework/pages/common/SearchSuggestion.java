package com.flipkart.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestion extends AbstractComponent {

    @FindBy(css = "[class*='_26x3Jb'] li._1va75j")
    private List<WebElement> suggestions;

    public SearchSuggestion(final WebDriver driver) {
        super(driver);
    }

    public void selectByIndex(String index) throws Exception {
        this.wait.until((d) -> this.suggestions.get(Integer.parseInt(index)).isDisplayed());
        this.suggestions.get(Integer.parseInt(index)).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.suggestions.size() > 3 && this.suggestions.get(3).isDisplayed());
    }
}
