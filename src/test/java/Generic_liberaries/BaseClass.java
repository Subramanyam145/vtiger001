package Generic_liberaries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericLiberaries.ExcelUtility;
import GenericLiberaries.IConstantPath;
import GenericLiberaries.JavaUtility;
import GenericLiberaries.PropertiesUtility;
import GenericLiberaries.WebDriverUtility;
import POMPage.ContactsPage;
import POMPage.CreateNewContactPage;
import POMPage.CreateNewEventPage;
import POMPage.CreateNewLeadPage;
import POMPage.CreateNewOrganizationPage;
import POMPage.DuplicatingLeadPage;
import POMPage.HomePage;
import POMPage.LeadsPage;
import POMPage.LoginPage;
import POMPage.NewContactInfoPage;
import POMPage.NewEventInfoPage;
import POMPage.NewLeadInfoPage;
import POMPage.NewOrgInfoPage;

public class BaseClass {
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected ContactsPage contacts;
	protected LeadsPage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewEventPage createEvent;
	protected CreateNewLeadPage createLead;
	protected NewOrgInfoPage newOrgInfo;
	protected NewContactInfoPage newContactInfo;
	protected NewLeadInfoPage newLeadInfo;
	protected NewEventInfoPage newEventInfo;
	protected DuplicatingLeadPage duplicatingLead;
	
	//@BeforeSuite
	//@BeforeTest@
	
	@BeforeClass
	public void classSetUp() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		web = new WebDriverUtility();
		
		property.propertiesIntialization(IConstantPath.PROPERTIES_PATH);
		driver = web.launchBrowser(property.readFromPropertiString("browser"));
		web.maximizeBrowser();
		web.WaitTillElementFound(Long.parseLong(property.readFromPropertiString("time")));
		
	}
	
	@BeforeMethod
	public void methodSetup() {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		login = new LoginPage(driver);
		home = new HomePage(driver);
		org = new OrganizationsPage(driver);
		contacts = new ContactsPage(driver);
		lead = new LeadsPage(driver);
		createOrg = new CreateNewOrganizationPage(driver);
		createContact = new CreateNewContactPage(driver);
		createEvent = new CreateNewEventPage(driver);
		createLead = new CreateNewLeadPage(driver);
		newOrgInfo = new NewContactInfoPage(driver);
		newContactInfo = new NewContactInfoPage(driver);
		newLeadInfo = new NewLeadInfoPage(driver);
		newEventInfo = new CreateNewEventPage(driver);
		duplicatingLead = new DuplicatingLeadPage(driver);
		
		
	}

}
