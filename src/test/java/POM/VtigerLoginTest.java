package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMPage.LoginPage;

public class VtigerLoginTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage login = new LoginPage(driver);
		login.loginToAPP("admin", "root");
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login passed");
		else
			System.out.println("Login Failed");
		
		driver.quit();

	}

}
