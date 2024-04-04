package com.academy.techcenture.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NopCommerceStepDefinitions {

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        System.out.println("user is on the home page");
    }
    @When("user clicks on the login link")
    public void user_clicks_on_the_login_link() {
        System.out.println("user clicks on the login link");
    }
    @Then("user should be navigate to login page")
    public void user_should_be_navigate_to_login_page() {
        System.out.println("user is navigated to login page");
    }
    @When("user uses login credentials {string} and {string} and clicks on login button")
    public void user_uses_login_credentials_and_and_clicks_on_login_button(String username, String password) {
        System.out.println("using " + username + " and " + password + " for login");
    }
    @Then("user should be able to log in")
    public void user_should_be_able_to_log_in() {
        System.out.println("user is logged in");
    }

}
