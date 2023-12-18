package com.playwright.pages;

import com.microsoft.playwright.Page;

public class TrustPage {

    Page page;
    private String trustSearchBox = "input[placeholder='Tell us something...']";
    private String submitBtn = "//div[@class='makeStyles-submitBtn-21']";
    private String here = "//a[contains(text(),'here')]";
    private String refreshIcon = "svg[data-testid='RefreshIcon']";
    private String thumbDownIcon = "//*[@data-testid='ThumbDownIcon']";
    private String redThumbDownIcon = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[2]";
    public String thumbUpIcon = "//*[@data-testid='ThumbUpIcon']";
    public String greenThumbUpIcon = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[1]";
    public String sendMsgTime = "(//p[contains(@class,'MessageTime')])[2]";
    public String responseMsgTime = "(//p[contains(@class,'MessageTime')])[3]";
    public String attachFileIcon = "svg[data-testid='AttachFileIcon']";
    public String emojiBtn = "svg[data-testid='SentimentVerySatisfiedIcon']";
    public String iframe = "iframe[id='kodif-chat-widget']";
    public String newConversationBtn = "//div/button[contains(text(),'Start a New Conversation')]";
    public String sessionHasExpired = "//div[@class='MuiBox-root css-1bkwata']";
    public String defaultMsg2 = "(//div[@class='makeStyles-messageBubble-31 makeStyles-agentMessageBubble-32'])[2]";
    public String uploadedFile = "//div[contains(text(),'GIT COMMANDS.docx')]";
    public String uploadWalletText = "//div[contains(text(),'What is wallet')]";
    public String fileInput = "input[type='file']";
    public String agentTalkResponse = "//div/p[contains(text(),'Sure! Please provide more details (e.g. transaction hash, relevant wallet addresses etc.) and I will have someone reach out to you. ')]";
    public String wrongEmailResponse = "//div/p[contains(text(),'The email')]";
    public String posEmailResponse = "//div/p[contains(text(),'Please select your issue:')]";
    public String moreBtn = "//button[text()='More']";
    public String otherBtn = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > button:nth-child(2)";
    public String selectSubCategory = "//div/p[contains(text(),'Please select sub-category:')]";
    public String subCategoryResponse = "//button[2]";
    //@FindBy(xpath = "//button[normalize-space()='General/ How To's/ Guides']")
    public String SubCatMsg = "//div/p[contains(text(),'Please provide any relevant details such as your OS, app version, transaction hash, wallet address, etc:')]";

    //@FindBy(xpath = "//div/p[contains(text(),'It looks like you currently have an open ticket. Our support team will respond within 3-5 business days. Creating multiple tickets for a single issue may increase your wait time.')]")
    public String supportTeamResponse = "//p[contains(text(),'It looks like you currently have an open ticket. O')]";
    public String boxContainer = "//div[@class='makeStyles-quickRepliesBoxContainerMini-13']";
    public String bouncingLouder = "//div[contains(@class, 'bouncing-loader')]";

}


