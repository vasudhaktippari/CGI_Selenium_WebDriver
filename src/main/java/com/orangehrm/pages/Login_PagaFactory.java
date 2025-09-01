 package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_PagaFactory {

    WebDriver driver;

    // ✅ Updated locators for latest OrangeHRM
    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    // Constructor
    public Login_PagaFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String uname) {
        usernameField.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        passwordField.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }
}
