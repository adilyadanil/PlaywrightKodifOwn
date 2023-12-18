package com.playwright.steps;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.setDefaultAssertionTimeout;
import static org.junit.Assert.assertNotNull;


public class TrustStepDef {

        private Browser browser;
        private Page page;
        private Page popupPage;

    @Given("the user is on the TrustWallet chat interface")
    public void theUserIsOnTheTrustWalletChatInterface() {

        try (Playwright playwright = Playwright.create()) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            page = context.newPage();
            setDefaultAssertionTimeout(10000);
            // Navigate to the page containing the frame
            page.navigate("https://support.trustwallet.com/en/support/home");

            // Interact with elements within the frame
            page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").click();
            page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").fill("What is wallet?");
            page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").press("Enter");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @When("the user asks a question and receives a response with a link")
    public void theUserAsksAQuestionAndReceivesAResponseWithALink() {
        // Wait for a popup window to open
       popupPage = page.waitForPopup(() -> {
            page.frameLocator("#kodif-chat-widget").getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("here")).click();
        });
    }

    @Then("the link provided should not be blank")
    public void theLinkProvidedShouldNotBeBlank() {
        // Make sure the popup page is not null
        assertNotNull(popupPage);

        // Wait for the popup page to load (change to the desired load state if needed)
        popupPage.waitForLoadState(LoadState.LOAD);

        // Get the href attribute of the link and assert that it is not empty
        String linkHref = popupPage.getAttribute("your-link-selector", "href");
        Assert.assertFalse("Link is blank", linkHref.isEmpty());
    }

@When("the user clicks the thumbs-up icon")
    public void theUserClicksTheThumbsUpIcon() {
            page.frameLocator("#kodif-chat-widget").getByRole(AriaRole.BUTTON).nth(1).click();

    }

    @Then("the thumbs-up icon should change color to green")
    public void theThumbsUpIconShouldChangeColorToGreen() {
    }

    @And("the thumbs-down icon should remain unchanged")
    public void theThumbsDownIconShouldRemainUnchanged() {
    }

    @When("the user clicks the thumbs-down icon")
    public void theUserClicksTheThumbsDownIcon() {
        page.frameLocator("#kodif-chat-widget").getByRole(AriaRole.BUTTON).nth(2).click();
    }

    @Then("the thumbs-down icon should change color to red")
    public void theThumbsDownIconShouldChangeColorToRed() {
    }

    @And("the thumbs-up icon should remain unchanged")
    public void theThumbsUpIconShouldRemainUnchanged() {
    }

    @When("the user records the time the question was sent")
    public void theUserRecordsTheTimeTheQuestionWasSent() {
    }

    @And("records the time the response was received")
    public void recordsTheTimeTheResponseWasReceived() {
    }

    @Then("the time difference between sending and receiving should be calculated")
    public void theTimeDifferenceBetweenSendingAndReceivingShouldBeCalculated() {
    }

    @And("the calculated time difference should be within an acceptable threshold")
    public void theCalculatedTimeDifferenceShouldBeWithinAnAcceptableThreshold() {
    }

    @When("the user clicks the refresh button")
    public void theUserClicksTheRefreshButton() {
       // page.frameLocator("#kodif-chat-widget").getByLabel("Start New Conversation").click();
    }

    @Then("the chat interface should reload and clear the previous response")
    public void theChatInterfaceShouldReloadAndClearThePreviousResponse() {
    }

    @Then("check for the presence of the default message")
    public void checkForThePresenceOfTheDefaultMessage() {
    }

    @When("the user clicks the attachment button")
    public void theUserClicksTheAttachmentButton() {
    }

    @Then("a file attachment dialog should appear")
    public void aFileAttachmentDialogShouldAppear() {
    }

    @When("the user clicks the emoji button")
    public void theUserClicksTheEmojiButton() {
    }

    @Then("an emoji selection dialog should appear")
    public void anEmojiSelectionDialogShouldAppear() {
    }

    @When("the user selects a .docx file to attach")
    public void theUserSelectsADocxFileToAttach() {
    }

    @Then("file is successfully attached")
    public void fileIsSuccessfullyAttached() {
    }

    @When("the user ask to talk with agent and use wrong email")
    public void theUserAskToTalkWithAgentAndUseWrongEmail() {
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").click();
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").fill("talk agent");
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").press("Enter");
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").click();
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").fill("11.com@");
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").press("Enter");
    }

    @Then("the chatbot will ask for correct email")
    public void theChatbotWillAskForCorrectEmail() {
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").click();
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").fill("kodif@test1.com");
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").press("Enter");

    }

    @When("the user ask to talk with agent and use correct email")
    public void theUserAskToTalkWithAgentAndUseCorrectEmail() {
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").click();
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").fill("talk agent");
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").press("Enter");
    }

    @And("the chatbot will ask to select the issue and provide More, Other option buttons")
    public void theChatbotWillAskToSelectTheIssueAndProvideMoreOtherOptionButtons() {
        page.frameLocator("#kodif-chat-widget").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("More")).click();
    }

    @And("user clicks Other option")
    public void userClicksOtherOption() {
        page.frameLocator("#kodif-chat-widget").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Other")).click();
    }

    @And("user selects sub-category issue and provide more detail")
    public void userSelectsSubCategoryIssueAndProvideMoreDetail() {
        page.frameLocator("#kodif-chat-widget").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("General/ How To's/ Guides")).click();
    }

    @Then("user select yes or no and the conversation will end")
    public void userSelectYesOrNoAndTheConversationWillEnd() {
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").click();
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").fill("ignore ut's kodif test");
        page.frameLocator("#kodif-chat-widget").getByPlaceholder("Tell us something...").press("Enter");
        page.frameLocator("#kodif-chat-widget").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Yes")).click();
        popupPage.close();
        browser.close();
    }
}
