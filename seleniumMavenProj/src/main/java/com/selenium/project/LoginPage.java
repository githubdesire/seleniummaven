package com.selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static By loginLocator = By.id("loginId");
    public static By passwordLocator = By.id("password");
    public static By submitButtonLocator = By.id("submit-btn");

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
System
    }

    public static void logInWithUsernameAndPassword
            (String loginId, String password, WebDriver driver) {

        driver.findElement(loginLocator).sendKeys(loginId);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
    }

    @FindBy(how = How.ID, using = "loginId")
    private WebElement loginId;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    @FindBy(how = How.ID, using = "submit-btn")
    private WebElement submit;

    public void logIn(String loginId, String password) {
        this.loginId.sendKeys(loginId);
        this.password.sendKeys(password);
        this.submit.click();
    }

    

}
