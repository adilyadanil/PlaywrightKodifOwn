package com.playwright.utility;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;

public class PlaywrightUtils {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static void initializePlaywright() {
        playwright = Playwright.create();
    }

    public static void launchBrowser(String browserType) {
        browser = playwright.chromium().launch();
        context = browser.newContext();
        page = context.newPage();
    }

    public static Page getPage() {
        return page;
    }

    public static void navigateTo(String url) {
        page.navigate(url);
    }

    public static void closeBrowser() {
        if (playwright != null) {
            playwright.close();
        }
    }

    // Add more Playwright-specific utility methods as needed

    // For example:
    public static ElementHandle findElement(String selector) {
        return page.querySelector(selector);
    }
}

