package com.altruist.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Constants used in the Stock Finance project.
 */
public interface Constants {
    String urlStockPage = "https://www.google.com/finance/";
    int durationSeconds = 10;
    String expectedStockPageTitle = "Google Finance - Stock Market Prices, Real-time Quotes & Business News";
    int expectedStockCount = 6;
    List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA");

}
