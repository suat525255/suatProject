package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("signin_button")).click();
    }
    @Given("User logins with username {string} and password {string}")
    public void user_logins_with_username_and_password(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String pageName) {
        String currentTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title is not matching",currentTitle.toLowerCase().contains(pageName.toLowerCase()));

        String selectedTab = new AccountSummaryPage().selectedTab.getText();
        Assert.assertEquals("Page is NOT matching",pageName,selectedTab);

    }

    @Then("Error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedText) {
        String actualText = loginPage.errorMessage.getText();
        Assert.assertEquals("Error message DO NOT match",expectedText,actualText);
    }
}