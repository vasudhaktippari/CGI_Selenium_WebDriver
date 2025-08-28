 package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * This is the Page Object class.
 *
 * It contains:
 * - Locators for userName, password, login button, and dashBoard.
 * - Methods (actions) that perform operations on those locators
 *   (enter userName, enter password, click button, check dashBoard).
 *
 * It represents the Login Page of the application.
 */

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By uname = By.name("username");
    By pword = By.name("password");
    By submit = By.xpath("//button[@type='submit']");
    By Dashbord=By.xpath("//h6[text()='Dashboard']");

    public void enterusername(String username) {
        driver.findElement(uname).sendKeys(username);
    }

    public boolean usernameisdisplayed() {
        return driver.findElement(uname).isDisplayed();
    }

    public String unamegetattributevalue() {
        return driver.findElement(uname).getAttribute("placeholder");
    }

    public boolean dashisdisplayed() {
        return driver.findElement(Dashbord).isDisplayed();
    }

    public void enterpassword(String password) {
        driver.findElement(pword).sendKeys(password);
    }

    public void clickonbutton() {
        driver.findElement(submit).click();
    }
}