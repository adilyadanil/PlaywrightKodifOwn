package com.playwright.utility;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class PlaywrightDriver {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    public

    PlaywrightDriver() {
        playwright = Playwright.create();
    }


    public void launchBrowser(String browserName) throws Exception {
        System.out.println("Launching browser: " + browserName);

        switch (browserName.toLowerCase()) {
            case

                    "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case

                    "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case

                    "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case

                    "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }

    public Page getPage() {
        return page;
    }

    public void takeScreenshot(String screenshotName) throws Exception {
        if (page == null) {
            throw new Exception("No page available for screenshot");
        }
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotName)));

    }

    // Additional methods for managing cookies, logs, etc.

}