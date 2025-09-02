 package com.orangehrm.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    static String projectpath = System.getProperty("user.dir");

    public static ExtentReports getinstance(String testName) {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String reportPath = projectpath + "\\src\\main\\resources\\Orangehrm_Reports\\"
                    + testName + "_" + timestamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            System.out.println("Extent Report Path: " + reportPath);


            //  Add System Info here
            extent.setSystemInfo("Project Name", "OrangeHRM Automation");
            extent.setSystemInfo("Tester", "Vasudha");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("OS Version", System.getProperty("os.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }
}  