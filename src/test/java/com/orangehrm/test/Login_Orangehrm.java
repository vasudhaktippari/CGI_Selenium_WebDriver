 package com.orangehrm.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.Base.BaseTest;
import com.orangehrm.pages.Login_PagaFactory;
import com.orangehrm.utilities.ExcelUtilities;
import com.orangehrm.utilities.ScreenshotUtilities;

public class Login_Orangehrm extends BaseTest {

    static String projectPath = System.getProperty("user.dir");

    @Test(dataProvider = "logindata")
    public void verifyLogin(String username, String password) throws IOException {
        test = extent.createTest("Login with the user: " + username);

        // Initialize PageFactory
        Login_PagaFactory obj = PageFactory.initElements(driver, Login_PagaFactory.class);
        obj.enterUsername(username);
        obj.enterPassword(password);
        obj.clickLogin();

        // Validation
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("dashboard")) {
            test.pass("Login successful. Dashboard URL matched: " + currentUrl);
        } else {
            String screenPath = ScreenshotUtilities.captureScreenshot(driver, "Login_Failed_" + username);
            test.fail("Login unsuccessful. Current URL: " + currentUrl)
                .addScreenCaptureFromPath(screenPath);
        }
    }

    @DataProvider
    public Object[][] logindata() throws IOException {
        String excelPath = projectPath + "src\\main\\resources\\Orangehrm_Testdata\\DataSheet.xlsx";
        return ExcelUtilities.getdata(excelPath, "Sheet1"); // ensure method matches
    }
}
