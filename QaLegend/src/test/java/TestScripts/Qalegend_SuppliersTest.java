package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Constants;
import PageClasses.QaLegendContactsPage;
import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendUserPage;
import PageClasses.Qalegend_Loginpage;
import Utilities.ExcelUtilities;
import Utilities.Fakertility;

public class Qalegend_SuppliersTest extends Base_Class{
	WebDriver driver;
	
	@Test
	public void addSuppliers() throws IOException, InterruptedException
	{
		loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.endTourButtonClick();
		homePage.clickOnContactsBtn();
		homePage.clickOnSupplierBtn();
		supplierpage.addSupplierBtn().click();
		String supname = ExcelUtilities.getStringData(1, 0, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		String supbusname = ExcelUtilities.getStringData(1, 1, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		String mobnum = ExcelUtilities.getIntegerData(1, 2, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		//double mobnum = Fakertility.getRandomNumber();
		supplierpage.addSupplierString(supname, supbusname, mobnum);
		supplierpage.searchSupplier(supname);
		Thread.sleep(3000);
		Assert.assertEquals(supplierpage.supplierNameSearch(), supname);	
	}
	@Test
	public void editSupplier() throws InterruptedException, IOException
	{
		loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.endTourButtonClick();
		homePage.clickOnContactsBtn();
		homePage.clickOnSupplierBtn();
		supplierpage.addSupplierBtn().click();
		String supname = ExcelUtilities.getStringData(1, 0, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		String supbusname = ExcelUtilities.getStringData(1, 1, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		String mobnum = ExcelUtilities.getIntegerData(1, 2, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		//double mobnum = Fakertility.getRandomNumber();
		supplierpage.addSupplierString(supname, supbusname, mobnum);
		supplierpage.searchSupplier(supname);
		Thread.sleep(3000);
		supplierpage.clickActionBtn();
		Thread.sleep(3000);
		supplierpage.clickOnEditBtn();
		Thread.sleep(3000);
		String supbussinessname = ExcelUtilities.getStringData(1, 3, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		supplierpage.editSupplierBusinessName(supbussinessname);
		supplierpage.clickOnUpdateBtn();
		Thread.sleep(3000);
		supplierpage.searchSupplier(supname);
		Thread.sleep(3000);	
	}
	@Test
	public void deleteSupplier() throws InterruptedException, IOException
	{
		loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.endTourButtonClick();
		homePage.clickOnContactsBtn();
		homePage.clickOnSupplierBtn();
		supplierpage.addSupplierBtn().click();
		String supname = ExcelUtilities.getStringData(1, 0, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		String supbusname = ExcelUtilities.getStringData(1, 1, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		String mobnum = ExcelUtilities.getIntegerData(1, 2, Constants.EXCELFILEPATH, "Sheet1")+Fakertility.getRandomNumber();
		supplierpage.addSupplierString(supname, supbusname, mobnum);
		supplierpage.searchSupplier(supname);
		Thread.sleep(3000);
		supplierpage.clickActionBtn();
		Thread.sleep(3000);
		supplierpage.clickOnDeleteBtn();
		Thread.sleep(3000);
		supplierpage.searchSupplier(supname);
		Thread.sleep(3000);
		Assert.assertEquals(supplierpage.getsupplierTableStatus(), "No matching records found");
	}

}
