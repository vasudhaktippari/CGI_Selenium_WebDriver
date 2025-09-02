package com.orangehrm.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinations {
	WebDriver driver;
	@Given("Open the Browser")
	public void open_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}

	@Given("Navigate to the url")
	public void navigate_to_the_url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	}
	@Then("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}

	@Then("Enter the valid username and password")
	public void enter_the_valid_username_and_password() {
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@Then("Click on Login")
	public void click_on_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Verify login success")
	public void verify_login_success() {
		System.out.println("login success");
	    
	}

	@Then("Enter the invalid username and password")
	public void enter_the_invalid_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("vasudha");
	    driver.findElement(By.name("password")).sendKeys("vasu@123");
	    
	}

	@Then("Verify login unsuccess")
	public void verify_login_unsuccess() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	



}
