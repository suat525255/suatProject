package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryStepDefs {


    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {

        List<WebElement> accountsElements = new AccountSummaryPage().accounts;
        // I need to turn the list of webelements into list of strings
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountsElements);

        Assert.assertEquals("Account Types are NOT as expected",expectedAccountTypes,actualAccountTypes);


    }
    @Then("Credit Accounts table must have columns")
    public void credit_accounts_table_must_have_columns(List<String> expectedColumns) {
        // for shortcut in Windows ALT+ENTER
        List<String> actualColumnNames = BrowserUtils.getElementsText(new AccountSummaryPage().creditColumns);

        Assert.assertEquals("Columns are NOT as expected",expectedColumns,actualColumnNames);



    }

}