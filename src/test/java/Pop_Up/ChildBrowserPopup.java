package Pop_Up;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildBrowserPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//To close the login window
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		//Search for mobile and click on Search icon
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		//Click on first mobile
		driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F13 (Nightsky Green, 64 GB)']")).click();
		
		//new window opens, collect patent and child window address
		String parentID = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		//switch to child window
		for(String s : allWindows)
		{
			driver.switchTo().window(s);
		}
		
		//click on add to cart and close
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		Thread.sleep(3000);
		driver.close();
		
		//Switch to parent window and refresh
		driver.switchTo().window(parentID);
		driver.navigate().refresh();
		
		
		//check product added to cart
		WebElement cartIcon = driver.findElement(By.xpath("//div[@class='KK-o3G']"));
		if(cartIcon.getText().equals("1"))
			System.out.println("Item added to cart");
		else
			System.out.println("Add to cart failed");
		
		driver.quit();
		
		}
		
	}


