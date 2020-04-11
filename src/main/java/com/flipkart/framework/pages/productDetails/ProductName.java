package com.flipkart.framework.pages.productDetails;

import com.flipkart.framework.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductName extends AbstractComponent {
    public ProductName(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "._35KyD6")
    private WebElement productName;

    public String getName() {
        return this.productName.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.productName.isDisplayed());
    }
}
