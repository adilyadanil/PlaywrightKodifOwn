package com.playwright.steps;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.playwright.utility.PlaywrightConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CopilotStepDefs {

    Page page;

    public CopilotStepDefs(Page page) {
        this.page = page;
    }

    @When("user enters the username")
    public void user_enters_the_username() {
        Frame frame = waitForCoPilotFrame();
        frame.fill("input[placeholder='Tell us something...']", PlaywrightConfigurationReader.getPlaywrightProperty("salesForceUserName"));
    }

    @When("user enters the password")
    public void user_enters_the_password() {
        Frame frame = waitForCoPilotFrame();
        frame.fill("input[placeholder='Tell us something...']", PlaywrightConfigurationReader.getPlaywrightProperty("salesForcePassword"));
    }

    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
        Frame frame = waitForCoPilotFrame();
        frame.click("//div[@class='makeStyles-submitBtn-21']");
    }

    @And("when the user clicks on the Kodif icon, the coPilot window pops up")
    public void whenTheUserClicksOnTheKodifIconTheCoPilotWindowPopsUp() {
        Frame frame = waitForCoPilotFrame();
        frame.click("Your Kodif icon selector here");
    }

    // Rest of your step definitions...

    private Frame waitForCoPilotFrame() {
        Frame frame = null;
        try {
            page.waitForSelector("iframe[name='kodif-chat-widget']", new Page.WaitForSelectorOptions().setTimeout(20000));
            frame = page.frame("kodif-chat-widget");
            frame.waitForSelector("input[placeholder='Tell us something...']", new Frame.WaitForSelectorOptions().setTimeout(20000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }
}
