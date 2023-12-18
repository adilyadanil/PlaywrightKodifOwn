//package com.playwright.steps;
//
//import com.playwright.utility.PlaywrightConfigurationReader;
//import com.microsoft.playwright.*;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class TrustApiStepDefs {
//
//    Response response;
//
//    @When("user login with correct credential")
//    public void user_login_with_correct_credential() {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch();
//            Page page = browser.newPage();
//
//            Map<String, Object> userData = new HashMap<>();
//            userData.put("email", "usenkanov@gmail.com");
//            userData.put("password", "massword");
//
//            Map<String, String> headers = new HashMap<>();
//            headers.put("Content-Type", "application/json");
//
//            // Intercept network requests and respond with a custom JSON
//            page.route("**" + PlaywrightConfigurationReader.getPlaywrightProperty("baseURI") + "/login", route -> {
//                // Fulfill the response
//                route.fulfill(new Route.FulfillOptions()
//                        .setStatus(200)
//                        .setContentType("application/json")
//                        .setHeaders(headers)
//                        .setBody("{\"payload\":{\"accessToken\":\"yourAccessTokenValue\"}}"));
//            });
//
//            String loginUrl = PlaywrightConfigurationReader.getPlaywrightProperty("baseURI") + "/login";
//            page.navigate(loginUrl);
//
//            // You can handle the response using page.waitForResponse()
//
//            response = page.waitForResponse("**" + PlaywrightConfigurationReader.getPlaywrightProperty("baseURI") + "/login");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Then("success code should be {int} and url should be valid")
//    public void success_code_should_be_and_url_should_be_valid(Integer expectedStatusCode) {
//        // Validate the HTTP response code
//        int actualStatusCode = response.status();
//        System.out.println("Status Code: " + actualStatusCode);
//
//        if (actualStatusCode != expectedStatusCode) {
//            throw new AssertionError("Expected status code: " + expectedStatusCode + ", but got: " + actualStatusCode);
//        }
//    }
//}
