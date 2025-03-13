package TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Constants.Constants;
import PageClasses.QaLegendContactsPage;
import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendUserPage;
import PageClasses.Qalegend_Loginpage;
import Utilities.ExcelUtilities;
import Utilities.Fakertility;
import Utilities.RetryAnalyzer;
import Utilities.Waitutilities;

public class Qalegend_UsersTest extends Base_Class{
WebDriver driver;

@Test(retryAnalyzer = RetryAnalyzer.class, priority = 1)
public void createUser()
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnUserButton();
	userPage.addUserBtn().click();//corresponding to 3rd method
	String name = Fakertility.getFakeFirstName();
	String emailId = name+Fakertility.getRandomNumber()+"@gmail.com";
	String password = "amv123";
	userPage.addUserString(name,emailId,password);
	userPage.searchUser(emailId);
	Assert.assertEquals(userPage.userNameSearch(),name);
	
}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 2)
public void deleteUser()
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnUserButton();
	userPage.addUserBtn().click();//corresponding to 3rd method
	String name = Fakertility.getFakeFirstName();
	String emailId = name+Fakertility.getRandomNumber()+"@gmail.com";
	String password = "amv123";
	userPage.addUserString(name,emailId,password);
	userPage.searchUser(emailId);
	userPage.deleteUser();
	userPage.searchUser(emailId);
	Assert.assertEquals(userPage.getTableStatus(), "No matching records found");
}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 3, groups = "RoleGroup")
public void addRole()
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnRolesBtn();
	userPage.addRoleBtn().click();
	String rolename = Fakertility.getFakeFirstName();
	userPage.addRoleName(rolename);
	userPage.scrollBarRole();
	userPage.saveRoleBtn();
	userPage.searchRole(rolename);
	Assert.assertEquals(userPage.roleNameSearch(),rolename);
}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 5,groups = "RoleGroup")
public void listRole() throws InterruptedException
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnRolesBtn();
	userPage.entryFieldSelect();
	userPage.rolesSizeFinder();
	Assert.assertEquals(userPage.rolesSizeFinder(),100);
}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 4,groups = "RoleGroup")
public void editRole() throws InterruptedException
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnRolesBtn();
	userPage.editRole();
	//Thread.sleep(3000);
	userPage.selectCheckBox();
	//Thread.sleep(3000);
	userPage.scrollBarForEdit();
	//Thread.sleep(3000);
	userPage.updateRoleBtn();
	userPage.searchEditedRole();
	String edrname = "Cathy";
	Assert.assertEquals(userPage.searchEditedRole(),edrname);
	
		
}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 6)
public void addSalesCommissionAgent() throws InterruptedException
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnSalesCommissionAgent();
	userPage.addsalesCommissionBtn().click();
	String firstname = Fakertility.getFakeFirstName();
	String saleCommissionPercentage = "25";
	userPage.firstNameOfSalesCommissionAgent(firstname);
	userPage.salesCommissionPercentageField(saleCommissionPercentage);
	//Thread.sleep(3000);
	userPage.saveSalesCommissionAgentBtn();
	//Thread.sleep(3000);
	userPage.searchSalesCommissionAgent(firstname);
	//Thread.sleep(3000);
	Assert.assertEquals(userPage.salesCommissionAgentInTable(),firstname);
	
}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 7)
public void editSalesCommissionAgent() throws InterruptedException
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnSalesCommissionAgent();
	userPage.addsalesCommissionBtn().click();
	String firstname = Fakertility.getFakeFirstName();
	String saleCommissionPercentage = "25";
	userPage.firstNameOfSalesCommissionAgent(firstname);
	userPage.salesCommissionPercentageField(saleCommissionPercentage);
	//Thread.sleep(3000);
	userPage.saveSalesCommissionAgentBtn();
	userPage.searchSalesCommissionAgent(firstname);
	//Thread.sleep(3000);
	userPage.editSalesCommissionAgent();
	String addressOfSalesCommissionAgent = Fakertility.getFakecityName();
	userPage.editAddressOfSalesCommissionAgent(addressOfSalesCommissionAgent);
	//Thread.sleep(3000);
	userPage.saveSalesCommissionAgentBtn();
	//Thread.sleep(3000);
	userPage.searchSalesCommissionAgent(firstname);
	//Thread.sleep(3000);
	Assert.assertEquals(userPage.salesCommissionAgentInTable(),firstname);
}


}
