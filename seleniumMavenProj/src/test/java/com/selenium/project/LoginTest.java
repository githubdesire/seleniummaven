package com.selenium.project;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.project.DriverInitializer;
import com.selenium.project.IndexPage;
import com.selenium.project.LoginPage;

import static org.assertj.core.api.Assertions.*;

public class LoginTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void setUp() throws Exception {
        webDriver = DriverInitializer.getDriver();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }

    @Before
    public void navigate() {
        webDriver.get(DriverInitializer.getProperty("login.url"));
    }

    @Test
    public void login() {
        WebElement webElement = webDriver.findElement(By.id("loginId"));
        webElement.sendKeys("hi");
        webElement = webDriver.findElement(By.id("password"));
        webElement.sendKeys("hi");
        webElement = webDriver.findElement(By.id("submit-btn"));
        webElement.click();
        webElement = webDriver.findElement(By.id("loginId"));
        assertThat(webElement.getText()).isEqualTo("hi");

    }

    @Test
    public void loginPage1() {
        LoginPage.logInWithUsernameAndPassword("login", "password", webDriver);
        assertThat(webDriver.findElement(IndexPage.loginLocator).getText()).isEqualTo("login");
    }

    @Test
    public void loginPage2() {
        new LoginPage(webDriver).logIn("login", "password");
        assertThat(webDriver.findElement(IndexPage.loginLocator).getText()).isEqualTo("login");
    }

}
