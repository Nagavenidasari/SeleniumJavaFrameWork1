package test;
import pages.GoogleSearchPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPageTest {
	
	static WebDriver driver = null;
	public static void main(String[] args) {
		googleSearchTest();
		
	}
	
	public static void googleSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		GoogleSearchPageObjects searchpage = new GoogleSearchPageObjects(driver);
		searchpage.setTextSrchBox("Selenium");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchpage.clkbtnsearch();
		String pgtitle=driver.getTitle();
		System.out.print(pgtitle);
		driver.close();
	}

}
