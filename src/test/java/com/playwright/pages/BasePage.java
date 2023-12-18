package com.playwright.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected Page page;

    // Define string locators for your elements
    private String usernameLocator = "//input[@class='input r4 wide mb16 mt8 username']";
    private String passwordLocator = "//input[@class='input r4 wide mb16 mt8 password']";
    private String loginButtonLocator = "//input[@class='button r4 wide primary']";
    private String coPilotIconLocator = "//div[@id='kodif-extension-root']//button[@type='button']";
    private String ticketSwitchDefaultTextLocator = "//p[@data-test-id='kodif-intro-msg']";

    // Constructor to initialize elements
    public BasePage(Page page) {
        this.page = page;
    }

    // Provide public methods to interact with the elements
    public void enterUsername(String text) {
        page.locator(usernameLocator).first().fill(text);
    }

    public void enterPassword(String text) {
        page.locator(passwordLocator).first().fill(text);
    }

    public void clickLoginButton() {
        page.locator(loginButtonLocator).first().click();
    }

    public void clickCoPilotIcon() {
        page.locator(coPilotIconLocator).first().click();
    }

    public String getTicketSwitchDefaultText() {
        return page.locator(ticketSwitchDefaultTextLocator).first().textContent();
    }
}