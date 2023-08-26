package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount = 2)
	public void demo1() {
		Reporter.log("demo1", true);
	}
	
	@Test(priority = -1)
	public void demo2() {
		Reporter.log("demo2", true);
	}

	
	@Test(invocationCount = -3)
	public void demo3() {
		Reporter.log("demo3", true);
	}

	
	@Test(invocationTimeOut = 0)
	public void demo4() {
		Reporter.log("demo4", true);
	}
	
	@Test
	public void demo5() {
		Reporter.log("demo5", true);
	}

	@Test
	public void demo6() {
		Reporter.log("demo6", true);
	}



}
