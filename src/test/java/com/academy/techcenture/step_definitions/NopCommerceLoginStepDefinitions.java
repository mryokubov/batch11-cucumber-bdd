package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.ConfigReader;
import static com.academy.techcenture.driver.Driver.*;

import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NopCommerceLoginStepDefinitions {
    

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        getDriver().get(ConfigReader.getProperty("url"));
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("Home page titles do not match", actualTitle, "nopCommerce demo store");
    }
    @When("user clicks on the login link")
    public void user_clicks_on_the_login_link() {
        WebElement loginLink = getDriver().findElement(By.linkText("Log in"));
        Assert.assertTrue("Login link is not displayed", loginLink.isDisplayed());
        loginLink.click();
    }
    @Then("user should be navigate to login page")
    public void user_should_be_navigate_to_login_page() {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("Login page titles do not match", actualTitle, "nopCommerce demo store. Login");
        WebElement loginHeader = getDriver().findElement(By.className("page-title"));
        Assert.assertTrue("Login Header is not displayed",loginHeader.isDisplayed());
    }
    @When("user uses login credentials {string} and {string} and clicks on login button")
    public void user_uses_login_credentials_and_and_clicks_on_login_button(String username, String password) {
        WebElement emailInput = getDriver().findElement(By.id("Email"));
        emailInput.sendKeys(username);
        WebElement passwordInput = getDriver().findElement(By.id("Password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = getDriver().findElement(By.xpath("//button[contains(@class,'login-button')]"));
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();
    }
    @Then("user should see my account and logout links on top")
    public void user_should_see_my_account_and_logout_links_on_top() {
        WebElement myAccountLink = getDriver().findElement(By.linkText("My account"));
        Assert.assertTrue(myAccountLink.isDisplayed());
        WebElement logOutLink = getDriver().findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutLink.isDisplayed());
    }

    @Then("user should see error {string}")
    public void userShouldSeeError(String errorMessage) {
        WebElement error = getDriver().findElement(By.xpath("//div[contains(@class,'validation-summary-errors')]"));
        Assert.assertTrue(error.isDisplayed());
        String actualErrorMessage = error.getText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue(actualErrorMessage.contains(errorMessage));
    }

    @And("user logs out from their account")
    public void userLogsOutFromTheirAccount() {

        try{
            WebElement logOutLink = getDriver().findElement(By.linkText("Log out"));
            Assert.assertTrue(logOutLink.isDisplayed());
            logOutLink.click();
        }catch (Exception e){

        }


    }
}
