package com.playwright.steps;

import com.microsoft.playwright.Page;
import com.playwright.utility.PlaywrightConfigurationReader;
import com.playwright.utility.PlaywrightDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static PlaywrightDriver playwrightDriver;

    @Before("@ui")
    public static void setUp() throws Exception {
        playwrightDriver = new PlaywrightDriver();
        playwrightDriver.launchBrowser(PlaywrightConfigurationReader.getPlaywrightProperty("browser")); // Pass the actual browser name here
    }

    public static PlaywrightDriver getPlaywrightDriver() {
        return playwrightDriver;
    }

    @After("@ui")
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Page page = playwrightDriver.getPage();
            byte[] screenshot = page.screenshot();
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        playwrightDriver.closeBrowser();
    }
}