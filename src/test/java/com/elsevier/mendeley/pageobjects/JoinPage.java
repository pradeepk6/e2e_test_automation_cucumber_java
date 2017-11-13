package com.elsevier.mendeley.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static com.elsevier.mendeley.pageobjects.HomePage.url;

public class JoinPage extends Page {

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div/div/div/div/form/div[1]/p/button")
    public WebElement continue_submit;

    @FindBy(how = How.ID, using = "email")
    public WebElement email;

    @FindBy(how = How.XPATH, using = "//div[@data-for='email']")
    public WebElement email_errMsg_div;

    @FindBy(how = How.ID, using = "username_in_use_in_mendeley")
    public WebElement email_inuse_errMsg_div;


    @FindBy(how = How.ID, using = "first_name")
    public WebElement first_name;

    @FindBy(how = How.XPATH, using = "//div[@data-for='first_name']")
    public WebElement first_name_errMsg_div;

    @FindBy(how = How.ID, using = "last_name")
    public WebElement last_name;

    @FindBy(how = How.XPATH, using = "//div[@data-for='first_name']")
    public WebElement last_name_errMsg_div;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//div[@data-for='password']")
    public WebElement password_errMsg_div;

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div/div/div/h1/span[2]")
    // /html/body/div/section/div/div/div/h1/span[2]
    public WebElement lastStepGreetingTitle;


    public JoinPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        boolean bool = false;
        // utility method in super that waits and checks
        bool = checkVisibilityofElemLocated(By.id("email"));
        //occassionally above check is not enough as browser throws
        //button click error : 'some other area would receive the click' and so wait for page to load
        //below method is after the above wait for check as it coud check current page's
        //page load and not the new one
        waitforPageToLoad(); //method in super
        return bool;
    }

    public void clickSubmitExpectingError() throws Exception{
        //before clicking make sure element is visible and clickable
        checkElementClickable(continue_submit);
        continue_submit.click();
    }
    public boolean isEmailRequired() {
        return email_errMsg_div.getText().contains("required");
    }

    public boolean isFirstNameRequired() {
        return first_name_errMsg_div.getText().contains("required");
    }
    public boolean isLastNameRequired() {
        return last_name_errMsg_div.getText().contains("required");
    }
    public boolean isPasswordRequired() {
        return password_errMsg_div.getText().contains("required");
    }
    public String getErrMsgForEmail() {
        return email_errMsg_div.getText();
    }
    public String getErrMsgForEmailInUse() {
        //wait for element to appear
        checkVisibilityofElemLocated(By.id("username_in_use_in_mendeley"));
        return email_inuse_errMsg_div.getText();
    }
    public String getErrMsgForPassword() {
        //wait for element to appear
        checkVisibilityofElemLocated(By.xpath("//div[@data-for='password']"));
        return password_errMsg_div.getText();
    }
    public String getLastStepGreetingTitle() {
        checkVisibilityofElemLocated(By.xpath("/html/body/div/section/div/div/div/h1/span[2]"));
        return lastStepGreetingTitle.getText();
    }

}
