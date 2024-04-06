package com.academy.techcenture.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.academy.techcenture.driver.Driver.getDriver;

public class NopCommerceUserRegistrationStepDefinitions {

    @Then("user should be able to see register button and click it")
    public void user_should_be_able_to_see_register_button_and_click_it() {
        WebElement registerBtn = getDriver().findElement(By.xpath("//button[text()='Register']"));
        Assert.assertTrue(registerBtn.isEnabled());
        registerBtn.click();
    }
    @Then("user should be navigate to register page")
    public void user_should_be_navigate_to_register_page() {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("nopCommerce demo store. Register", actualTitle);
        WebElement registerHeader = getDriver().findElement(By.tagName("h1"));
        Assert.assertTrue(registerHeader.isDisplayed());
    }
    @Then("user clicks on gender as {string}")
    public void user_clicks_on_gender_as(String gender) {
        getDriver().findElement(By.id("gender-"+gender)).click();
    }
    @Then("user enters {string} for firstname")
    public void user_enters_for_firstname(String firstname) {
        getDriver().findElement(By.id("FirstName")).sendKeys(firstname);
    }
    @Then("user enters {string} for lastname")
    public void user_enters_for_lastname(String lastname) {
        getDriver().findElement(By.id("LastName")).sendKeys(lastname);
    }
    @Then("user enters {int}, {string}, {int} for dob")
    public void user_enters_for_dob(int day, String month, int year) {
        Select selectDay = new Select(getDriver().findElement(By.name("DateOfBirthDay")));
        Select selectMonth = new Select(getDriver().findElement(By.name("DateOfBirthMonth")));
        Select selectYear = new Select(getDriver().findElement(By.name("DateOfBirthYear")));

        selectDay.selectByVisibleText(String.valueOf(day));
        selectMonth.selectByVisibleText(month);
        selectYear.selectByVisibleText(String.valueOf(year));
    }
    @Then("user enters {string}")
    public void user_enters(String email) {
        getDriver().findElement(By.id("Email")).sendKeys(email);
    }
    @Then("user enters {string} for company")
    public void user_enters_for_company(String companyName) {
        getDriver().findElement(By.id("Company")).sendKeys(companyName);
    }
    @Then("user {string} newsletter checkbox")
    public void user_newsletter_checkbox(String checks) {
        WebElement newsletterCheckBox = getDriver().findElement(By.id("Newsletter"));
        if (checks.equals("checks")){
            if (!newsletterCheckBox.isSelected()){
                newsletterCheckBox.click();
            }
        }else if (checks.equals("unchecks")){
            if (newsletterCheckBox.isSelected()){
                newsletterCheckBox.click();
            }
        }
    }
    @Then("user enters {string} for password input")
    public void user_enters_for_password_input(String password) {
        getDriver().findElement(By.id("Password")).sendKeys(password);
    }
    @Then("user enters {string} for confirm password input")
    public void user_enters_for_confirm_password_input(String confirmPassword) {
        getDriver().findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        WebElement registerButton = getDriver().findElement(By.id("register-button"));
        Assert.assertTrue(registerButton.isEnabled());
        registerButton.click();
    }
    @Then("user should see {string} success message")
    public void user_should_see_success_message(String successMessage) {
        WebElement confirmationMessage = getDriver().findElement(By.className("result"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
        Assert.assertEquals(successMessage, confirmationMessage.getText());
    }
    @When("user clicks on continue button")
    public void user_clicks_on_continue_button() {
        WebElement continueBtn = getDriver().findElement(By.xpath("//a[text()='Continue']"));
        Assert.assertTrue(continueBtn.isEnabled());
        continueBtn.click();
    }

    @And("user checks if they can log in with newly created credentials {string} and {string}")
    public void userChecksIfTheyCanLogInWithNewlyCreatedCredentialsAnd(String username, String password) {

        try {
            WebElement logInLink = getDriver().findElement(By.linkText("Log in"));
            logInLink.click();
        }catch (Exception e){
            WebElement logOutLink = getDriver().findElement(By.linkText("Log out"));
            logOutLink.click();
        }
        login(username, password);
    }

    private void login(String username, String password) {
        WebElement logInLink = getDriver().findElement(By.linkText("Log in"));
        logInLink.click();

        WebElement emailInput = getDriver().findElement(By.id("Email"));
        emailInput.sendKeys(username);
        WebElement passwordInput = getDriver().findElement(By.id("Password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = getDriver().findElement(By.xpath("//button[contains(@class,'login-button')]"));
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();
    }
}
