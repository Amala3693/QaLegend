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

import com.github.javafaker.Faker;

import Constants.Constants;
import PageClasses.QaLegendContactsPage;
import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendUserPage;
import PageClasses.Qalegend_Loginpage;
import Utilities.ExcelUtilities;
import Utilities.Fakertility;
import Utilities.Waitutilities;

public class Qalegend_UsersTest extends Base_Class{
WebDriver driver;

@Test
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
@Test
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
@Test
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
}
@Test
public void listRole() throws InterruptedException
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnRolesBtn();
	userPage.entryFieldSelect();
	Thread.sleep(3000);
	//Waitutilities.waitForVisibilityOfElement(rol, driver);
	userPage.rolesSizeFinder();
}
@Test
public void editRole() throws InterruptedException
{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homePage.endTourButtonClick();
	homePage.clickOnAnUserManagementButton();
	homePage.clickOnRolesBtn();
	userPage.editRole();
	Thread.sleep(3000);
	userPage.selectCheckBox();
	Thread.sleep(3000);
	userPage.scrollBarForEdit();
	Thread.sleep(3000);
	userPage.updateRoleBtn();
}
@Test
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
	Thread.sleep(3000);
	userPage.saveSalesCommissionAgentBtn();
}
@Test
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
	Thread.sleep(3000);
	userPage.saveSalesCommissionAgentBtn();
	userPage.searchSalesCommissionAgent(firstname);
	Thread.sleep(3000);
	userPage.editSalesCommissionAgent();
	String addressOfSalesCommissionAgent = Fakertility.getFakecityName();
	userPage.editAddressOfSalesCommissionAgent(addressOfSalesCommissionAgent);
	Thread.sleep(3000);
	userPage.saveSalesCommissionAgentBtn();
}

}
