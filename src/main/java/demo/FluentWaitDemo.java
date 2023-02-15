package demo;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {
	
	public static void main(String[] args) throws InterruptedException{
		
		test();
	}
	
	public static void test() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class);
		
		  WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       WebElement ele=driver.findElement(By.xpath("//*[@id=\'arc-srp_130\']/div/div[9]/div/div/div[1]/div[1]/a/h3"));
			       
			       if(ele.isEnabled()) {
			    	   System.out.println("Element Found");
			    	  
			       }
			       return ele;
			     }
			   });
		
		 element.click(); 
		 //driver.findElement(By.xpath("//*[@id=\'arc-srp_130\']/div/div[9]/div/div/div[1]/div[1]/a/h3")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
		
		
		
	}

}
