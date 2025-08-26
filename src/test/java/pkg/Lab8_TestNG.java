package pkg;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Lab8_TestNG {
    WebDriver driver;

    @Test
    public void lab8_1() {
        // Click on Desktops menu
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        // Click on "Mac (1)" under Desktops
        driver.findElement(By.linkText("Mac (1)")).click();

        // Select Sort: Name (A - Z)
        WebElement sort = driver.findElement(By.id("input-sort"));
        Select sort1 = new Select(sort);
        sort1.selectByVisibleText("Name (A - Z)");

        // Click on Add to Cart button of first product
        driver.findElement(By.xpath("//button[@data-original-title='Add to Cart']")).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for elements
        driver.get("https://tutorialsninja.com/demo/index.php?");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
