package POMPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLiberaries.WebDriverUtility;

public class CreateNewContactPage {

	// Declaration

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name = "lastname")
	private WebElement lastNanoTF;
	@FindBy(xpath = "//img(contains (Sonclick, 'Accountsfaction')]")
	WebElement orgPlusButton;
	private List<WebElement> orglist;
	@FindBy (xpath = "//div[@id=' ListViewContents']/descendant::table[@cellspaceing='1']/descendant"
	private List<WebElement> orgList;
	@FindBy(xpath = "//input[normalize-space (@value)='Save')")
	private WebElement saveButton;

	// Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void setLastName(String lastName) {
		WebElement lastNameTF;
		lastNameTF.sendKeys(lastName);
	}

	public void selectExistingOrg(WebDriverUtility web, String requiredOrgName) {
		String parentID = web.getParentWindowID();
		web.switchToChildWindow();
		for (int i = 1; i < orgList.size(); i++) {
			if (orgList.get(i).getText().equals(requiredOrgName)) {
				System.out.println(orgList.get(i).getText());
			orgList.get(i).click();
			break;

		}
	}
	web.switchTowindows(parentID);

	}

	public void clickSavaButton() {
		saveButton.click();
}
}
