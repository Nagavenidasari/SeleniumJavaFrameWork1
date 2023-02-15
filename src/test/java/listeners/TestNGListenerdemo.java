package listeners;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerdemo {

	@Test(priority=2)
	public void test1() {
		System.out.println("I am inside test1");
	}
	
	@Test(priority=1)
	public void test2() throws InterruptedException {
		System.out.println("I am inside test2");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String Title=driver.getTitle();
		System.out.println(Title);
		Thread.sleep(3000);
		
		
		//Assert.assertTrue(Title, false);
		driver.close();
		Assert.assertEquals("Google", Title);
	}
	
	@Test(priority=4)
	public void test3() {
		System.out.println("I am inside test3");
		throw new SkipException("Test3 Skipped");
	}
	
	@Test(priority=3)
	public void test4() {
		System.out.println("I am inside test4");
	}

}
