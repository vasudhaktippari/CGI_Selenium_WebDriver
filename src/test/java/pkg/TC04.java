package pkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.myntra.com/");
				
				List<WebElement> alllinks = driver.findElements(By.tagName("a"));
				
				System.out.println("Total links is:"+alllinks.size());
				
				for(WebElement link:alllinks) {
					System.out.println("The link is:"+link.getText());
					
				}
				

	}

}
