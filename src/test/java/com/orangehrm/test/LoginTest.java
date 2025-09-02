 package com.orangehrm.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.Base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.Excelutilities;
import com.orangehrm.utilities.ScreenshotUtilities;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "logindata")
    public void verifylogin(String username, String password) throws IOException {
        test = extent.createTest("Login Test with user: " + username);

        // Navigate to OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Perform Login via POM
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Wait & Capture Full Page Screenshot with timestamp
        String screenshotPath = ScreenshotUtilities.capturescreen(driver, "Login_" + username);
        test.addScreenCaptureFromPath(screenshotPath);

        // 🔹 Assertion
        if (loginPage.isLoginSuccessful()) {
            test.pass("Login successful for user: " + username);
            Assert.assertTrue(true, "Login successful for user: " + username);
        } else {
            String error = loginPage.getErrorMessage();
            test.fail("Login failed for user: " + username + " | Error: " + error);

            //   screenshot on failure
            String failShot = ScreenshotUtilities.capturescreen(driver, "LoginFail_" + username);
            test.addScreenCaptureFromPath(failShot);

            Assert.fail("Login failed for user: " + username + " | Error: " + error);
        }
    }

    @DataProvider
    public Object[][] logindata() throws IOException {
        return Excelutilities.getdata("Sheet1");  // Excel Data
    }
}