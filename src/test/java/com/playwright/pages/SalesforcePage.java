package com.playwright.pages;

import com.microsoft.playwright.Page;

public class SalesforcePage extends BasePage {

    private final Page page;

    // Define locator strings for your elements
    private String copilotFrame = "//div[@class='chakra-stack App css-11sckxr']";
    private String maximizeBtn = "//button[@data-test-id='kodif-expand-btn']";
    private String minimizeBtn = "//button[@data-test-id='kodif-minimize-btn']";
    private String commandButton = "//button[@data-test-id=\"kodif-commands-btn\"]";
    private String commandInput = "//textarea[@data-test-id='kodif-text-command-input']";
    private String casesBox = "(//span[contains(text(),'Cases')])[1]";
    private String caseNum = "(//a[@title='05359938 | Case'])[1]";
    private String suggestionAction = "//div[@data-test-id='/suggestion']";
    private String insertBtn = "(//div[contains(@class,'actions')]/span)[2]";
    private String thinkingProcessIcon = "//div[@class='css-y1opvk']";
    private String dockBtn = "//button[@data-test-id='kodif-dock-btn']";
    private String reloadBtn = "//button[@data-test-id='kodif-reload-btn']";
    private String reloadDefaultContent = "//div[@class='chakra-stack Examples css-1221klb']";

    public SalesforcePage(Page page) {
        super(page);
        this.page = page;
    }

    // Provide public methods to interact with the elements using locators
    // For example:
    public void clickMaximizeBtn() {
        page.locator(maximizeBtn).click();
    }

    public void fillCommandInput(String text) {
        page.locator(commandInput).fill(text);
    }

}
