package com.flipkart.framework.pages.searchResults;

import com.flipkart.framework.pages.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ResultList extends AbstractComponent {

    public ResultList(WebDriver driver) {
        super(driver);;
    }

    @FindBy(css = "._1UoZlX")
    private List<WebElement> results;

    /**
     * selectRandomResultAndReturnProductInfo();
     *
     * Selects a random result from the result list
     * @return product name and price in a Map<String, String>
     *
     */
    public Map<String, String> selectRandomResultAndReturnProductInfo() {

        int resultCount = results.size();
        Random random = new Random();
        int randomResult = random.nextInt(resultCount);

        /* *
         * Getting product information corresponding to the same random result as being selected.
         *
         * we're replacing the three dots ... in the product name with an empty string
         * so that we can compare this substring with the product name from product details page
         */
        String productName = results.get(randomResult).findElement(By.cssSelector("._3wU53n")).getText()
                .replace("...","");

        String price = results.get(randomResult).findElement(By.cssSelector("._1UoZlX [class*='_1vC4OE']")).getText()
                .replace("...","");

        Map<String, String> Map = new HashMap<>();
        Map.put("name", productName);
        Map.put("price", price);

        results.get(randomResult).click();

        return Map;
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.results.size() > 0);
    }
}
