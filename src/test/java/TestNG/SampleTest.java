package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void demp() {
		Reporter.log("Hello World!", true);
	}

}
