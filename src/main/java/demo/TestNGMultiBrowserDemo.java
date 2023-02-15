package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGMultiBrowserDemo {
	

	static WebDriver driver = null;
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		
		System.out.println("Browser Name: "+browserName);
		System.out.println("Thread ID: "+ Thread.currentThread().getId());
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else  if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
		
	}
	
	
	@Test
	public void Test1() throws InterruptedException {
		
		driver.get("https://www.cnn.com");
		
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		
		System.out.println("Tearing down");
		//Thread.sleep(2000);
		driver.close();
	}

}
