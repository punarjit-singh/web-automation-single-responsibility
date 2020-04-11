package com.flipkart.test.purchase;

import com.flipkart.framework.utils.JsonHelper;
import com.flipkart.test.base.BaseTest;
import com.flipkart.framework.pages.home.HomePage;
import com.flipkart.framework.pages.productDetails.ProductDetailsPage;
import com.flipkart.framework.pages.searchResults.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Map;

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
    private JsonHelper jsonHelper;

    @BeforeTest
    public void setupPages() {
        this.homePage = new HomePage(driver);
        this.searchResultsPage = new SearchResultsPage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.jsonHelper = new JsonHelper();
    }

    @Test
    public void compareProductDetails() throws Exception {

        /*
         * For demonstration purposes, reading test data from external json
         */
        String projectRoot = System.getProperty("user.dir");
        Map<?,?> testData = jsonHelper.readJson(projectRoot + "/src/test/java/com/flipkart/test/testdata/flipkartTestData.json");

        homePage.goTo(testData.get("baseUrl").toString());
        homePage.getLoginLink().click();
        Assert.assertTrue(homePage.getLoginWidget().isDisplayed());

        homePage.getLoginWidget().login(testData.get("email").toString(), testData.get("password").toString());
        Assert.assertTrue(homePage.getMyAccountLink().isDisplayed());

        homePage.waitForPageLoaded();

        homePage.getSearchWidget().enter(testData.get("keyword").toString());
        Assert.assertTrue(searchResultsPage.getResultList().isDisplayed());

        /*
         * From Selenium 2 onwards scroll to the element is handled automatically
         * so there's no need to add an explicit method that scrolls element into view
         * Although we can explicitly scroll an element into view with a custom js as below:
         * ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
         */
        Map<String, String> productInfoFromResults = searchResultsPage.getResultList().selectRandomResultAndReturnProductInfo();
        productDetailsPage.switchToProductDetailsWindow();
        Assert.assertTrue(productDetailsPage.getProductName().isDisplayed());

        String productNameFromDetails = productDetailsPage.getProductName().getName();
        String productPriceFromDetails = productDetailsPage.getProductPrice().getPrice();

        Assert.assertTrue(productNameFromDetails.contains( productInfoFromResults.get("name")),
                "productNameFromResults: " + productInfoFromResults.get("name") +
                        " | productNameFromDetails: " + productNameFromDetails);

        Assert.assertTrue(productPriceFromDetails.contains( productInfoFromResults.get("price")),
                "productPriceFromResults: " + productInfoFromResults.get("price") +
                        " | productPriceFromDetails: " + productPriceFromDetails);

    }

}
