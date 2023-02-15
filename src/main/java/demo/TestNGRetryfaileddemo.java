package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryfaileddemo {
	
	@Test
	public void Test1() {
		System.out.println("I am inside Test1");
	}
	
	@Test
	public void Test2() {
		System.out.println("I am inside Test2");
		//int i = 1/0;
	}
	
	@Test
	public void Test3() {
		System.out.println("I am inside Test3");
		Assert.assertTrue(0>1);
	}
	
	@Test
	public void Test4() {
		System.out.println("I am inside Test4");
	}
	@Test
	public void Test5() {
		System.out.println("I am inside Test5");
	}



}
