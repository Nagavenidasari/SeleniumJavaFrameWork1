package demo;

import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})// when declared at class level, all tests by default a part of that particular group
public class TestNGGoupsDemo {
	
	@Test(groups= {"sanity","smoke"})
	public void test1() {
		System.out.println("This is test1");
	}
	@Test(groups= {"smoke"})
	public void test2() {
		System.out.println("This is test2");
	}
	@Test(groups= {"sanity","smoke","regression"})
	public void test3() {
		System.out.println("This is test3");
	}
	@Test(groups= {"windows.regression"})
	public void test4() {
		System.out.println("This is test4");
	}
	@Test(groups= {"linux.regression"})
	public void test5() {
		System.out.println("This is test5");
	}
	
	@Test
	public void test6() {
		System.out.println("This is test6");
	}

}
