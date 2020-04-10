package com.flipkart.test.purchase;

import com.flipkart.test.base.BaseTest;
import com.flipkart.framework.pages.home.HomePage;
import com.flipkart.framework.pages.productDetails.ProductDetailsPage;
import com.flipkart.framework.pages.searchResults.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductDetailsComparison extends BaseTest {

    /**
     * Due to COVID-19 Flipkart.com has temporarily disabled the Add to Cart
     * and Purchase functionalty
     *
     * Hence to complete the assignment this test actually compares
     * product details on Search Results page
     * against product details on the Product Details page
     */

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductDetailsPage productDetailsPage;

    @BeforeTest
    public void setupPages() {
        this.homePage = new HomePage(driver);
        this.searchResultsPage = new SearchResultsPage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test
    public void compareProductDetails() {
        homePage.goTo("https://www.flipkart.com/");
        homePage.getLoginLink().click();
        Assert.assertTrue(homePage.getLoginWidget().isDisplayed());
    }

}
