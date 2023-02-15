package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {

	static WebDriver driver = null;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Selenium");
		
		// Click in enter on the keyboard.
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
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
