package Pop_Up;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingAutoIt {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()='Upload Resume']"));
		Thread.sleep(2000);
		
		Runtime.getRuntime().exec("C:\\Users\\HP\\Desktop\\AutroIT\\Fileupload.exe");
		Thread.sleep(1000);
		System.out.println("sucess");
		driver.quit();

	}

}
