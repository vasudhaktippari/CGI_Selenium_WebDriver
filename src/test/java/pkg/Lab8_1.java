package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		WebElement mac=driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
		String mac1=mac.getText();
		if(mac1.equals("Mac")) {
			System.out.println("Mac is verified");
		}
		else {
			System.out.println("Mac is not verified");
		}
		WebElement sort=driver.findElement(By.id("input-sort"));
		Select sort1=new Select(sort);
		sort1.selectByContainsVisibleText("Name (A - Z)");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"input-search\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Monitors");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();

	}

}
