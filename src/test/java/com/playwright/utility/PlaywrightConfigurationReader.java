package com.playwright.utility;

import com.microsoft.playwright.options.BrowserChannel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightConfigurationReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        } catch (IOException e) {
            System.out.println("File not found in PlaywrightConfigurationReader class");
            e.printStackTrace();
        }
    }

    public static String getPlaywrightProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public static BrowserChannel getBrowserChannel() {
        String channel = getPlaywrightProperty("browser.channel");
        return BrowserChannel.valueOf(channel.toUpperCase());
    }

    // Add other methods to retrieve Playwright-related properties as needed
}

