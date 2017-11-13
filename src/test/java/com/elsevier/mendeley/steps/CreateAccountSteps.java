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

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CreateAccountSteps {

    @Autowired
    WebDriver driver;

    HomePage homePage;
    JoinPage joinPage;
    private String firstName;

    public CreateAccountSteps() {
    }

    @Before
    public void setUp() {
    }

    @Given("^I have navigated to join page$")
    public void i_have_navigated_to_join_page() throws Throwable {
        homePage = new HomePage(driver);
        homePage.clickCreateAccount();
        joinPage = new JoinPage(driver);
        if (!joinPage.isOnPage()) fail();
    }

    @When("^I do NOT fill in fields : email,firstName,lastName,password and submit$")
    public void i_do_NOT_fill_in_fields_email_firstName_lastName_password_and_submit() throws Throwable {
        joinPage.clickSubmitExpectingError();
    }

    @Then("^I should see Required validation failure for all the mentioned fields$")
    public void i_should_see_Required_validation_failure_for_all_the_mentioned_fields() throws Throwable {
        assertTrue(joinPage.isEmailRequired());
        assertTrue(joinPage.isFirstNameRequired());
        assertTrue(joinPage.isLastNameRequired());
        assertTrue(joinPage.isPasswordRequired());
    }

    @When("^I fill in (.*) for email,(.*) for firstName,(.*) for lastName,(.*) for password and submit$")
    public void i_fill_in_for_email_firnam_for_firstName_lasnam_for_lastName_for_password_and_submit
            (String email, String firnam, String lasnam, String pass) throws Throwable {
        if(email.equalsIgnoreCase("generate randomly")) {
            email = randomEmailGenerator();
        }
        joinPage.email.sendKeys(email);
        joinPage.first_name.sendKeys(firnam);
        this.firstName = firnam;
        joinPage.last_name.sendKeys(lasnam);
        joinPage.password.sendKeys(pass);
        joinPage.clickSubmitExpectingError();
    }
    @Then("^I should see error message$")
    public void i_should_see_error_message(String errMsg) throws Throwable {
        assertTrue(joinPage.getErrMsgForEmail().contains(errMsg));
    }
    @Then("^I should see password validation error message$")
    public void i_should_see_password_validation_error_message(String errMsg) throws Throwable {
        assertTrue(joinPage.getErrMsgForPassword().contains(errMsg));
    }

    /*
    @When("^I fill in (.*) for email,(.*) for firstName,(.*) for lastName,(.*) for password$")
    public void i_fill_in_for_email_firnam_for_firstName_lasnam_for_lastName_for_password
            (String email, String firnam, String lasnam, String pass) throws Throwable {
        if(email.equalsIgnoreCase("generate randomly")) {
            email = randomEmailGenerator();
        }
        System.out.println("email = " + email);
        joinPage.email.sendKeys(email);
        joinPage.first_name.sendKeys(firnam);
        joinPage.last_name.sendKeys(lasnam);
        joinPage.password.sendKeys(pass);
        //joinPage.clickSubmitExpectingError();
    }
    */

    @When("^I fill in a pre-exiting email (.*)$")
    public void i_fill_in_a_pre_exiting_email_com_vb(String email) throws Throwable {
        joinPage.email.sendKeys(email);
    }

    @When("^goto to next field so as to trigger asynchromous validation of email field$")
    public void goto_to_next_field_so_as_to_trigger_asynchromous_validation_of_email_field() throws Throwable {
        joinPage.first_name.sendKeys(" ");
    }

    @Then("^I should see email in use error message$")
    public void i_should_see_email_in_use_error_message(String errMsg) throws Throwable {
        assertTrue(joinPage.getErrMsgForEmailInUse().contains(errMsg));
    }

    @Then("^I should progress to next step and see a message addressing me with my firstName$")
    public void i_should_progress_to_next_step_and_see_a_message_addressing_me_with_my_firstName() throws Throwable {
        assertTrue(joinPage.getLastStepGreetingTitle().contains(this.firstName));
    }

    //utility method to generate emails randomly
    private String randomEmailGenerator() {
        Random random = new Random();
        return String.valueOf(random.nextInt()) + "@" + String.valueOf(random.nextInt()) + ".com";
    }


}
