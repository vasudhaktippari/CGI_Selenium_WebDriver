 package com.orangehrm.Base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;   // Shared report for suite
    protected ExtentTest test;               // Per-test method node

    @BeforeSuite
    public void setupReport() {
        // One report for whole suite
        extent = ExtentManager.getinstance("OrangeHRM_TestSuite");
    }

    @BeforeMethod
    public void setup(Method method) {
        WebDriverManager.chromedriver().setup();

        //  Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        // Hide "Chrome is being controlled by automated software" message
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Chrome Preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        prefs.put("profile.default_content_setting_values.autofill", 2);
        prefs.put("autofill.profile_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create ExtentTest node per test method
        String testName = method.getName();
        test = extent.createTest(testName);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}