package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class TestNGIgnoredemo {

	@Ignore
	@Test
	public void Test1() {
		System.out.println("I am inside Test1");
	}
	
	@Test
	public void Test2() {
		System.out.println("I am inside Test2");
	}
	
	@Test
	public void Test3() {
		System.out.println("I am inside Test3");
	}
}
