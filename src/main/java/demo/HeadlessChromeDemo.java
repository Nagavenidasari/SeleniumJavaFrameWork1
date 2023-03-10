package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDemo {
	
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	
	
	public static void test() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		String title=driver.getTitle();
		System.out.println(title);
		driver.close();
		System.out.println("Test Completed");
		
	}

	
}
