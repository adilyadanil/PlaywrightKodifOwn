package com.playwright.pages;

import com.microsoft.playwright.Page;

public class ZendeskPage {

    private final Page page;

    public ZendeskPage(Page page) {
        this.page = page;
    }

    private String zenDeskUserName = "//input[@id='user_email']";
    private String zenDeskPassword = "//input[@id='user_password']";
    private String zenDeskLoginBtn = "//button[@id='sign-in-submit-button']";
    private String zendeskSearchBoxOnMain = "//div[@data-test-id='header-toolbar-search-button']";
    private String ticket = "(//div[@data-entity-id='2522'])[1]";
    private String zendeskSearchBox = "//input[@data-garden-id='forms.media_input']";

}

