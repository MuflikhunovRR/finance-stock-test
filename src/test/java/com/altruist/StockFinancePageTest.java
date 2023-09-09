package com.altruist;

import com.altruist.pagesEvents.StockFinancePageEvents;
import com.altruist.utils.BaseTest;
import com.altruist.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Stock Finance page functionality.
 */
public class StockFinancePageTest extends BaseTest {

    private StockFinancePageEvents stockFinancePage = new StockFinancePageEvents();

    @Test(priority = 1, description = "Verify Stock Page Title")
    public void stockPageTitleTest() {
        stockFinancePage.verifyStockPageTitle();
    }

    @Test(priority = 2, description = "Retrieve Stock Symbols")
    public void verifyStockSymbolCount() {
        List<String> actualStockSymbols = stockFinancePage.getStockSymbols();
        Assert.assertEquals(actualStockSymbols.size(), Constants.expectedStockCount,
                "Stock symbol count mismatch.");
    }

    @Test(priority = 3, description = "Compare Stock Symbols")
    public void compareStockSymbol() {
        List<String> actualStockSymbols = stockFinancePage.getStockSymbols();

        List<String> missingInActual = new ArrayList<>();
        List<String> missingInExpected = new ArrayList<>();

        actualStockSymbols.forEach(symbol -> {
            if (!Constants.expectedStockSymbols.contains(symbol)) {
                missingInExpected.add(symbol);
            }
        });

        Constants.expectedStockSymbols.forEach(symbol -> {
            if (!actualStockSymbols.contains(symbol)) {
                missingInActual.add(symbol);
            }
        });

        System.out.println("Stock symbols in actualStockSymbols but not in expectedStockSymbols:");
        missingInExpected.forEach(System.out::println);

        System.out.println("\nStock symbols in expectedStockSymbols but not in actualStockSymbols:");
        missingInActual.forEach(System.out::println);
    }

}