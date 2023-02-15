package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsTestNG {
	static WebDriver driver = null;
	ExtentReports extent = null;
	ExtentTest test = null;
	
	@BeforeSuite
	public void setup()
	{
		extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        extent.attachReporter(spark);
       
	}
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
	
	
	@Test
	public void test1() {
		test = extent.createTest("GoogleSearch Test1","This is a test to validate google search functionality");
		
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
		test.addScreenCaptureFromPath("GoogleSearch.png");
		String title=driver.getTitle();
		System.out.print(title);
		test.log(Status.PASS, "Test Passed");
		test.pass("Test Passed and closed the browser");
		test.info("Test Completed");
	}
	
	@Test
	public void test2() {
		test = extent.createTest("GoogleSearch Test1","This is a test to validate google search functionality");
		driver.get("https://google.com");
		test.log(Status.INFO, "Opened google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Automation");
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
		test.addScreenCaptureFromPath("GoogleSearch1.png");
		String title=driver.getTitle();
		System.out.print(title);
		test.log(Status.FAIL, "Test Failed");
		test.fail("Test Passed and closed the browser");
		test.info("Test Completed");
	}
	
	@AfterTest
	public void Aftertest() {
		driver.close();
		driver.quit();
	}
	
	
	@AfterSuite
	public void teardown() {
		
		extent.flush();
	}

}
