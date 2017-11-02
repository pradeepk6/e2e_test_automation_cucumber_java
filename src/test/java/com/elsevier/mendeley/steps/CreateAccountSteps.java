package com.elsevier.mendeley.steps;

import com.elsevier.mendeley.pageobjects.HomePage;
import com.elsevier.mendeley.pageobjects.JoinPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class CreateAccountSteps {

    @Autowired
    WebDriver driver;

    HomePage homePage;
    JoinPage joinPage;

    public CreateAccountSteps() {
    }

    @Before
    public void initPageObjects() {
        //driver init must happen before page init
        driver.get(HomePage.url);
    }


    @Given("^I am on join page$")
    public void i_am_on_join_page() throws Throwable {
        homePage = new HomePage(driver);
        joinPage = homePage.clickCreateAccount();
    }

    @When("^I do NOT fill in anything  for email, for firstName, for lastName, for password and submit$")
    public void i_do_NOT_fill_in_anything_for_email_for_firstName_for_lastName_for_password_and_submit() throws Throwable {
        joinPage.clickSubmitExpectingError();
    }

    @Then("^I should see Required validation failure$")
    public void i_should_see_Required_validation_failure() throws Throwable {
        assertTrue(joinPage.isEmailRequired());
        assertTrue(joinPage.isFirstNameRequired());
        assertTrue(joinPage.isLastNameRequired());
        assertTrue(joinPage.isPasswordRequired());
    }

}
