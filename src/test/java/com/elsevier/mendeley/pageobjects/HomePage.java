package com.elsevier.mendeley.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.StringTokenizer;

/**
 * Created by user
 */
public class HomePage extends Page {

    public static String url = "http://mendeley.com";
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create")
    public WebElement createAccount;

    JoinPage joinPage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public JoinPage clickCreateAccount() {
        createAccount.click();
        return new JoinPage(driver);
    }
}
