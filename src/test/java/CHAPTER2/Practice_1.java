package CHAPTER2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("dress");
		
		List<WebElement> List = driver.findElements(By.xpath("//li[@class='sbct' and @jsaction]"));
	
		//for(WebElement element: List) {
			//System.out.println(element.getText());
		//}
		
		for(int i=0; i<List.size();i++) {
			System.out.println(List.get(i).getText());
		}
		driver.quit();
		
				

	}

}
