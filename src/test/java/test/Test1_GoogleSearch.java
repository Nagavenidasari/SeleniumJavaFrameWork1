package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		
		googleSearch();
		


	}
	
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		//driver.findElement(By.name("btnK")).click();
		// Click in enter on the keyboard.
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String title=driver.getTitle();
		System.out.print(title);
		driver.close();
		
	}

}
