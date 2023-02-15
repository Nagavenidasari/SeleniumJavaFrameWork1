package test;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Propertiesfile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {
	
	static WebDriver driver = null;
	public static String browserName=null;
	
	
	@BeforeTest
	public void setUpTest() throws IOException {
		System.out.print("Test Started");
		Propertiesfile.getProperties();
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
				
	}
	@Test
	public static void googleSearch() {
		
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Click in enter on the keyboard.
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		String title=driver.getTitle();
		System.out.print(title);
		
		
	}
	
	
	@AfterTest
	public void tearDownTest() throws IOException
	{
		driver.close();
		//driver.quit();
		System.out.print("Test Completed");
		Propertiesfile.setProperties();
	}

}
