package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import PageClasses.QaLegendContactsPage;
import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendUserPage;
import PageClasses.Qalegend_Loginpage;
import Utilities.ScreenshotUtility;

public class Base_Class {
	
	public WebDriver driver;
	Qalegend_Loginpage loginpage;
	QaLegendHomePage homePage;
	QaLegendUserPage userPage;
	QaLegendContactsPage supplierpage;
	Properties prop;
	FileInputStream fis;
	public WebDriver initializeMethod(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
	
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("invalid brower name");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	@BeforeMethod(groups = "RoleGroup") //to run the groups
	@Parameters({"browser"})
	public void initializemethod(String browserName) throws Exception
	{
		driver= initializeMethod(browserName);
		prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\data.properties";
		fis = new FileInputStream(path);
		prop.load(fis);//loading the property file to prop object
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginpage = new Qalegend_Loginpage(driver);
		homePage = new QaLegendHomePage(driver);
		supplierpage = new QaLegendContactsPage(driver);
		userPage = new QaLegendUserPage(driver);
	}
	@AfterMethod
	public void afterMethod(ITestResult itResult) throws IOException {
		if(itResult.getStatus()==ITestResult.FAILURE) {
		ScreenshotUtility sc= new ScreenshotUtility();
		sc.captureFailureScreenshots(driver, itResult.getName());
		}
		if(driver!=null) {
			driver.quit();
		}
	}

}
