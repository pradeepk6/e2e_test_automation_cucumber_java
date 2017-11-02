package com.elsevier.mendeley.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.elsevier.mendeley.pageobjects.HomePage.url;

public class JoinPage extends Page {

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div/div/div/div/form/div[1]/p/button")
    public WebElement continue_submit;

    @FindBy(how = How.ID, using = "email")
    public WebElement email;
    @FindBy(how = How.XPATH, using = "//div[@data-for='email']")
    public WebElement email_errMsg_div;



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


    public JoinPage(WebDriver driver) {
        super(driver);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void clickSubmitExpectingError() throws Exception{
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

}
