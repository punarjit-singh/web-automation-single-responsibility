package com.flipkart.framework.pages.productDetails;

import com.flipkart.framework.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPrice extends AbstractComponent {
    public ProductPrice(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class*='_1vC4OE']")
    private WebElement productPrice;

    public String getPrice() {
        return this.productPrice.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.productPrice.isDisplayed());
    }
}
