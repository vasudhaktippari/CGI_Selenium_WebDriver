package pkg;

import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
 
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class ObjectModel {
	WebDriver driver;
  @Test(dataProvider="logindata")
  public void f(String username, String password) {
	  System.out.println("This is the test");
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPage objlogin=new LoginPage(driver);
			if(objlogin.usernameisdisplayed())
		{
			objlogin.enterusername(username);
		System.out.println("Get placeholder:"+objlogin.unamegetattributevalue());
		}
		else
		{
			System.out.println("username is not displayed");
		}
		objlogin.enterpassword(password);
		objlogin.clickonbutton();
		if(objlogin.dashisdisplayed())
		{
	Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

  }

  @BeforeMethod
  public void beforeMethod() {
	 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
  }
 
 
  @DataProvider
  public String[][] logindata() throws IOException {
      File file1 = new File("C:\\Users\\VASUDHA K T\\Documents\\mavenproj\\DataSheet.xlsx");
      FileInputStream fs = new FileInputStream(file1);
      XSSFWorkbook workbook = new XSSFWorkbook(fs);
      XSSFSheet worksheet = workbook.getSheetAt(0);

      int rowcount = worksheet.getPhysicalNumberOfRows();
      System.out.println("rows:" + rowcount);

      // Skipping header row
      String[][] data = new String[rowcount - 1][2];

      for (int i = 1; i < rowcount; i++) {
          data[i - 1][0] = worksheet.getRow(i).getCell(0).getStringCellValue();
          data[i - 1][1] = worksheet.getRow(i).getCell(1).getStringCellValue();
      }

      workbook.close();
      fs.close();

      return data;
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class");
  }
 
  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Class");
  }
 
  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test");
  }
 
  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test");
  }
 
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite");
  }
 
  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite");
  }
 
}