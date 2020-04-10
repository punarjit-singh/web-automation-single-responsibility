package com.flipkart.framework.pages.searchResults;

import com.flipkart.framework.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStat extends AbstractComponent {

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "._2yAnYN")
    private WebElement stat;

    public String getStat() {
        return this.stat.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.stat.isDisplayed());
    }
}
