package com.flipkart.framework.pages.searchResults;

import com.flipkart.framework.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends AbstractPage {

    private ResultList resultList;
    private ResultStat resultStat;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.resultList = PageFactory.initElements(driver, ResultList.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);
    }

    public ResultList getResultList() {
        return resultList;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }
}
