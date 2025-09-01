 package pkg;

 import org.openqa.selenium.By;
 import org.openqa.selenium.JavascriptExecutor;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.WebDriverWait;

 import io.github.bonigarcia.wdm.WebDriverManager;

 import java.time.Duration;

 public class TestCase6_Reg {

 	public static void main(String[] args) {
 		WebDriverManager.chromedriver().setup();
 		WebDriver driver = new ChromeDriver();
 		driver.manage().window().maximize();
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 		driver.get("https://automationexercise.com/");
 		System.out.println("Title:" + driver.getTitle());

 		// Go to login page
 		driver.findElement(By.linkText("Signup / Login")).click();

 		// Enter Registered email and password
 		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"))
 				.sendKeys("vasudha26@gmail.com");
 		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"))
 				.sendKeys("vasu@123");

 		// click on login
 		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

 		// Verifying login is successful
 		WebElement login = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
 		String loginCom = login.getText();
 		if (loginCom.equals("Logged in as vasudha")) {
 			System.out.println("Login is successful");
 		} else {
 			System.out.println("Login is not successful");
 		}

 		// Adding product to cart navigate to product page
 		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();

 		// Hover over first product to make "View Product" visible
 		WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"));
 		Actions actions = new Actions(driver);
 		actions.moveToElement(firstProduct).perform();

 		WebElement viewProduct = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
 		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProduct);
 		viewProduct.click();




 		// Click on Add to cart
 		driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

 		// Wait for modal and click View Cart
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
 		driver.findElement(By.xpath("//u[text()='View Cart']")).click();

 		// proceed to check out
 		driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();

 		// Click on place order
 		driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a")).click();
 		// Entring payemnt deatils  
 		driver.findElement(By.name("name_on_card")).sendKeys("Maverick Test");
 		driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
 		driver.findElement(By.name("cvc")).sendKeys("123");
 		driver.findElement(By.name("expiry_month")).sendKeys("12");
 		driver.findElement(By.name("expiry_year")).sendKeys("2025");

		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		//*[@id="form"]/div/div/div/p
		WebElement Order= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p"));
		String OrderConfirm=Order.getText();
		if(OrderConfirm.equals("Congratulations! Your order has been confirmed!")) {
			System.out.println("Order Placed Successfully");
		}
		else {
			System.out.println("Order has not Placed");
		}
		
		driver.quit();
	}
}
