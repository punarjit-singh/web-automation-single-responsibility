package com.flipkart.framework.pages.productDetails;

import com.flipkart.framework.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends AbstractPage {

    private ProductName productName;
    private ProductPrice productPrice;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.productName = PageFactory.initElements(driver, ProductName.class);
        this.productPrice = PageFactory.initElements(driver, ProductPrice.class);
    }

    public void switchToProductDetailsWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public ProductName getProductName() {
        return productName;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

}
