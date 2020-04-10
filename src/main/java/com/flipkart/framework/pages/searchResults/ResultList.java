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

    public Map<String, String> selectRandomResultAndReturnProductInfo() {

        int resultCount = results.size();
        Random random = new Random();
        int randomResult = random.nextInt(resultCount);
        results.get(randomResult).click();

        /* *
         * Getting product information corresponding to the same random result as being selected.
         */
        String productName = results.get(randomResult).findElement(By.cssSelector("._3wU53n")).getText();
        String price = results.get(randomResult).findElement(By.cssSelector("._1UoZlX [class*='_1vC4OE']")).getText();

        Map<String, String> Map = new HashMap<>();
        Map.put("productName", productName);
        Map.put("price", price);
        return Map;
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.results.size() > 0);
    }
}
