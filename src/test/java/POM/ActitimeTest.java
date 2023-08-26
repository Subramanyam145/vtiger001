package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMPage.ActitimeLogin;

public class ActitimeTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		ActitimeLogin login = new ActitimeLogin(driver);
		login.loginToAPP("admin", "manager");
		
		if(driver.getTitle().contains("atProductName"))
			System.out.println("Login passed");
		else
			System.out.println("Login Failed");
		
		driver.quit();

	}

}
