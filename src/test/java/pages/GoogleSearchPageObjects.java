package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {

	WebDriver driver = null;
	By textbox_search = By.name("q");
	By btn_submitsearch = By.name("btnK");
	
	//Creating a constructor to make java understand 
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void setTextSrchBox(String text)
	{
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clkbtnsearch()
	{
		driver.findElement(btn_submitsearch).sendKeys(Keys.RETURN);
	}

}
