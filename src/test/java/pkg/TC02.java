package pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get( "https://www.google.com");
		System.out.println("Get title:"+driver.getTitle());
		driver.manage().window().maximize();
		driver.navigate().to("https://www.yahoo.com");
		System.out.println("Get title:"+driver.getTitle());
		driver.navigate().back();
		System.out.println("title after back:"+driver.getTitle());
		driver.navigate().forward();
		System.out.println("title forward:"+driver.getTitle());
		
	}

}
