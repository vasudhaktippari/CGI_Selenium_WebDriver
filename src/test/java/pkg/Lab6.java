package pkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		driver.findElement(By.linkText("Components")).click();
		driver.findElement(By.linkText("Monitors (2)")).click();
		WebElement sort=driver.findElement(By.xpath("//*[@id=\"input-limit\"]"));
		Select sort1=new Select(sort);
		List<WebElement> l1=sort1.getOptions();
		sort1.selectByVisibleText("25");
		 
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[2]/button[1]")).click();
		driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[1]/h4/a")).get(0).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
		WebElement wish=driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		String Wish1=wish.getText();
		 
		if(Wish1.equals("Success: You have added")) {
			System.out.println("wish list is updated");
		}
		else{
			System.out.println( "You need to login to update wishlist");
		}
		WebElement Search=driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		 
		Search.sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.id("description")).click();
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).click();
		driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).sendKeys("3");
		//Add to cart
		driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();
		 
		WebElement cart=driver.findElement(By.id("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a"));
		String cart1=wish.getText();
		if(cart1.equals("HTC Touch HD")) {
			System.out.println("cart is added");
		}
		else{
			System.out.println("cart is not correct");
			 
		}
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
		driver.close();
		
	}

}
