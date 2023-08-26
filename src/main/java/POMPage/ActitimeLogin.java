package POMPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLogin {
	
	//Declaration
		@FindBy(name = "username")
		private WebElement usernameTF;
		
		@FindBy(name = "pwd")
		private WebElement passwordTF;
		
		@FindBy(id = "Logging in ...")
		private WebElement loginButton;
		
		//Initialization
		public ActitimeLogin (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public void loginToAPP(String username, String password) {
			usernameTF.sendKeys(username);
			passwordTF.sendKeys(password);
			loginButton.click();
		}

}

