package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PART1
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php");
		System.out.println("Title:"+driver.getTitle());
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		WebElement heading =driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		String HeadingText=heading.getText();
		if(HeadingText.equals("Register Account")) {
			System.out.println("Heading Verified:"+HeadingText);
			
		}
		else {
			System.out.println("Heading not Verified:"+HeadingText);
		}
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		WebElement warn=driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
		String Warning=warn.getText();
		if(Warning.equals("Warning: You must agree to the Privacy Policy!")){
			System.out.println("Warring Appeared:"+Warning);
		}
		else {
			System.out.println("Warring not Appeared:"+Warning);
			
		}
		//PART2
		WebElement Search=driver.findElement(By.id("input-firstname"));
	 
		Search.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		WebElement CharLim=driver.findElement( By.xpath("//*[@id=\"account\"]/div[2]/div/div"));
		String CharWarn=CharLim.getText();
		if(CharWarn.equals("First Name must be between 1 and 32 characters!")) {
			System.out.println("Warring Appeared:"+CharWarn);
		}
		else {
			System.out.println("Warring Not Appeared:"+CharWarn);
		}
		WebElement FirstName=driver.findElement(By.id("input-firstname"));
		FirstName.clear();
		FirstName.sendKeys("Vasudha");
		
		//Entering value to last name element
		WebElement Search2=driver.findElement(By.id("input-lastname"));
		 
		Search2.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		WebElement CharLimit=driver.findElement( By.xpath( "//*[@id=\"account\"]/div[3]/div/div"));
		String CharWarnLN=CharLimit.getText();
		if(CharWarnLN.equals("Last Name must be between 1 and 32 characters!")) {
			System.out.println("Warring Appeared:"+CharWarnLN);
		}
		else {
			System.out.println("Warring Not Appeared:"+CharWarnLN);
		}
		WebElement lastName=driver.findElement(By.id("input-lastname"));
		lastName.clear();
		lastName.sendKeys("K T");
		
		// entarig value to email field
		
		WebElement Search3=driver.findElement(By.id("input-email"));
		 
		Search3.sendKeys("vasudha@@gmail");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		WebElement CharLimitE=driver.findElement( By.xpath(" //*[@id=\"account\"]/div[4]/div/div"));
		String CharWarnE=CharLimit.getText();
		if(CharWarnE.equals("E-Mail Address does not appear to be valid!")) {
			System.out.println("Warring Appeared:"+CharWarnE);
		}
		else {
			System.out.println("Warring Not Appeared:"+CharWarnE);
		}
		WebElement email=driver.findElement(By.id("input-email"));
		email.clear();
		email.sendKeys("vasudha7@gmail.com");
		
		
		//Etering values between 3 and 32 in telephone
		WebElement search4 = driver.findElement(By.id("input-telephone"));
		search4.sendKeys("38");

		// Click Continue
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();

		// Capture warning
		WebElement charLimitTE = driver.findElement(By.xpath("//*[@id='account']/div[5]/div/div"));
		String charWarnTE = charLimitTE.getText();

		if (charWarnTE.equals("Telephone must be between 3 and 32 characters!")) {
		    System.out.println("Warning Appeared: " + charWarnTE);
		} else {
		    System.out.println("Warning Not Appeared. Actual: " + charWarnTE);
		}

		// Re-find telephone field after reload
		WebElement tel = driver.findElement(By.id("input-telephone"));
		tel.clear();
		tel.sendKeys("8975463210");

		 
		
	 
		// part 4
		//Entering Password and confirm password
		WebElement Search5=driver.findElement(By.id("input-password"));
		Search5.sendKeys("Test@123");
		
		WebElement Search6=driver.findElement(By.id("input-confirm"));
		Search6.sendKeys("Test@123");
		//newsletter 
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[1]/input") ).click();
		driver.findElement(By.xpath(" /html/body/div[2]/div/div/form/div/div/input[1]") ).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		 // verifying Account created
		WebElement AccCreat =driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		String AccCreated=AccCreat.getText(); 
		if( AccCreated.equals("Your Account Has Been Created!" )) {
			System.out.println("AccountCreated Verified:"+AccCreated);
			
		}
		else {
			System.out.println("Account NotCreated");
		}
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[1]/a")).click();
		
		driver.close();
	}

}
