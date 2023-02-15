package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_Demo;

public class Propertiesfile {
	static Properties prop = new Properties();
	static String path = System.getProperty("user.dir");

	public static void main(String[] args) throws IOException {
		getProperties();
		setProperties();

	}
	
	public static void getProperties() throws IOException {
		
		
		try {
			
			Properties prop = new Properties();
			String path = System.getProperty("user.dir");
			InputStream input = new FileInputStream(path+"//src//test//java//config//config.properties");
			InputStream input1 = new FileInputStream("C:\\Users\\nagav\\eclipse-workspace\\AutomationStepByStep\\SeleniumWebDriverManager\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println("Testing");
			System.out.println(browser);
			TestNG_Demo.browserName=browser;
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void setProperties() throws IOException {
		
		try {
			OutputStream out = new FileOutputStream(path + "//src//test//java//config//results.properties");
			prop.setProperty("result", "pass");
			prop.store(out, null);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
