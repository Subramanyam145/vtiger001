package Pop_Up;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Js_Prompt {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert a1 = driver.switchTo().alert();
		System.out.println(a1.getText());
		a1.getText();
		a1.sendKeys("I_am_IronMan");
		a1.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.quit();

	}

}
