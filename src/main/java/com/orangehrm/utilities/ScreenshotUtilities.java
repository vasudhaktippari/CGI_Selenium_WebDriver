 package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtilities {

    public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // Take screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define destination path
        String destPath = System.getProperty("user.dir") + "src\\main\\resources\\Orangehrm_Screenshot\\Screenshots\\" + screenshotName + ".png";
        File destFile = new File(destPath);

        // Create folder if not exists
        destFile.getParentFile().mkdirs();

        // Copy file
        Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return destPath;
    }
}
