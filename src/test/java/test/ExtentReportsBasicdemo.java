package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReportsBasicdemo {
	static WebDriver driver = null;

	public static void main(String[] args) {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		//ExtentHtmlReporter html = new ExtentHtmlReporter("user/build/name/Extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("GoogleSearch Test1","This is a test to validate google search functionality");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://google.com");
		test.log(Status.INFO, "Opened google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		test.log(Status.INFO, "Typed Selenium in the textbox");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Click in enter on the keyboard.
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.log(Status.INFO, "Clicked Enter");
		String title=driver.getTitle();
		System.out.print(title);
		driver.close();
		driver.quit();
		System.out.print("Test Completed");
		test.log(Status.PASS, "Test Passed");
		test.pass("Test Passed and closed the browser");
		test.info("Test Completed");
		extent.flush();
		
	}

}
