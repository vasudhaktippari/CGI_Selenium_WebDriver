package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get( "https://www.google.com");
		System.out.println("Get title:"+driver.getTitle());
		driver.manage().window().maximize();
		WebElement search=driver.findElement(By.id("APjFqb"));
		search.sendKeys("Automaton testing tools");
		search.submit();
		 

	}

}
