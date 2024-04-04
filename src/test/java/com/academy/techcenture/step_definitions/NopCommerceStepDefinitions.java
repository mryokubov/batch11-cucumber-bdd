package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NopCommerceStepDefinitions {

    private WebDriver driver;

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        driver.get(ConfigReader.getProperty("url"));
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Home page titles do not match", actualTitle, "nopCommerce demo store");
    }
    @When("user clicks on the login link")
    public void user_clicks_on_the_login_link() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        Assert.assertTrue("Login link is not displayed", loginLink.isDisplayed());
        loginLink.click();
    }
    @Then("user should be navigate to login page")
    public void user_should_be_navigate_to_login_page() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Login page titles do not match", actualTitle, "nopCommerce demo store. Login");
        WebElement loginHeader = driver.findElement(By.className("page-title"));
        Assert.assertTrue("Login Header is not displayed",loginHeader.isDisplayed());
    }
    @When("user uses login credentials {string} and {string} and clicks on login button")
    public void user_uses_login_credentials_and_and_clicks_on_login_button(String username, String password) {
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class,'login-button')]"));
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();
    }
    @Then("user should be able to log in")
    public void user_should_be_able_to_log_in() {
        WebElement myAccountLink = driver.findElement(By.linkText("My account"));
        Assert.assertTrue(myAccountLink.isDisplayed());
        WebElement logOutLink = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutLink.isDisplayed());
    }

    @Then("user should see error {string}")
    public void userShouldSeeError(String errorMessage ) {
        WebElement error = driver.findElement(By.xpath("//div[contains(@class,'validation-summary-errors')]"));
        String trimError = error.getText().trim();
        String compressedError = trimError.replaceAll("\\s+", " ");
        Assert.assertEquals(compressedError,errorMessage, "Not correct error message");
    }

    @Before
    public void beforeEachScenario(){
        driver = Driver.getDriver();
    }

    @After
    public void afterEachScenario(){
        Driver.quitDriver();
        driver = null;
    }
}
