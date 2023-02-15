package demo;

import org.testng.annotations.Test;

public class TestNGDependenciesDemo {
	
	@Test(dependsOnMethods = {"Test2","Test3"})
	public void Test1() {
		System.out.println("I am inside Test1");
	}
	
	@Test(groups="functional")
	public void Test2() {
		System.out.println("I am inside Test2");
	}
	
	@Test(dependsOnGroups = {"functional"})
	public void Test3() {
		System.out.println("I am inside Test3");
	}

}
