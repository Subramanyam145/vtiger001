package genericUtilityImplementation;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericLiberaries.ExcelUtility;
import GenericLiberaries.IConstantPath;
import GenericLiberaries.JavaUtility;
import GenericLiberaries.PropertiesUtility;
import GenericLiberaries.WebDriverUtility;

public class CreateOrganization {
	
	public static void main(String[] args) {
	PropertiesUtility property=new PropertiesUtility();
	ExcelUtility excel=new ExcelUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wdutil=new WebDriverUtility();
	
	property.propertiesIntialization(IConstantPath.PROPERTIES_PATH);
	excel.excelInitialization(IConstantPath.EXCEL_PATH);
	
	
	
//	WebDriver driver=new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.get("http://localhost:8888/");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	WebDriver driver = wdutil.launchBrowser(property.readFromPropertiString("browser"));
	wdutil.maximizeBrowser();
	wdutil.navigateToApp(property.readFromPropertiString("url"));
	wdutil.WaitTillElementFound(Long.parseLong(property.readFromPropertiString("time")));
	
	if(driver.getTitle().contains("vtiger"))
		System.out.println("Login page is displayed");
	else
		System.out.println("login page is not displayed");
	driver.findElement(By.name("user_name")).sendKeys(property.readFromPropertiString("username"));
	driver.findElement(By.name("user_password")).sendKeys(property.readFromPropertiString("password"));
	
	driver.findElement(By.id("submitButton")).submit();
	
	if(driver.getTitle().contains("Home"))
		System.out.println("Home page is displayed");
	else
		System.out.println("Home page is not found");
	
	driver.findElement(By.xpath("//a[text()='Organizations' and \"action=index\"]")).click();
	
	if(driver.getTitle().contains("Organisations"))
		System.out.println("Oragnisations page is displayed");
	else
		System.out.println("Organisations is not found");
	
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	WebElement creatorg=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	if(creatorg.equals("Creating New Organisation"))
		System.out.println("Create New Oragnisation page is displayed");
	else
		System.out.println("Creating New Organisation is not found");
	
	
	//Random random=new Random();
	//int randomNum=random.nextInt(100);
	Map<String, String> map = excel.readFromExcel("ORGANIZATION", "Create Organization");
	
	String orgName = map.get("Organization Name")+jutil.generateRandomNum(100);
	
	//String orgName="TCS"+randomNum;
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	
	String newOrgInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(newOrgInfo.contains(orgName))
	{
		
		System.out.println("Organisation created successfully");
		excel.writeTOExcel("ORGANIZATION", "Create Organization" , "Pass", IConstantPath.EXCEL_PATH);
	}
	else
	{
		System.out.println("Organisation not created");
		excel.writeTOExcel("ORGANIZATION", "Create Organization ", "Fail", IConstantPath.EXCEL_PATH);
	}
	
	WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	//Actions a=new Actions(driver);
	//a.moveToElement(adminIcon).perform();
	wdutil.mouseHover(adminIcon);
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	//driver.quit();
	wdutil.quitAllwindow();
	excel.closeExcel();

}
}
