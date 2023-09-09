package com.altruist.pagesEvents;

import com.altruist.pagesObjects.StockFinancePageElements;
import com.altruist.utils.BaseTest;
import com.altruist.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains methods for Stock Finance page interaction and validation.
 */
public class StockFinancePageEvents {

    public void verifyStockPageTitle() {
        Assert.assertEquals(BaseTest.driver.getTitle(), Constants.expectedStockPageTitle,
                "Stock Page title does not match the expected title.");
    }

    public List<String> getStockSymbols() {
        WebElement ulElement = BaseTest.driver.findElement(By.xpath(StockFinancePageElements.stockTable));
        List<WebElement> stockSymbolElements = ulElement.findElements(By.xpath(StockFinancePageElements.stockName));

        return stockSymbolElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}