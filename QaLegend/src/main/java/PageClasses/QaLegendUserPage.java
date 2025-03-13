package PageClasses;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;
import Utilities.Waitutilities;

public class QaLegendUserPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addUserButton;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirmPassword;
	@FindBy(xpath = "//button[@id='submit_user_button']")
	WebElement saveButton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchUserTextBox;
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//td)[2]")
	WebElement nameCell;
	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement userDeleteButton;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement deleteOkButton;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement emptyTable;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addRoleButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement roleNameField;
	@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
	WebElement saveRoleButton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchRoleBox;
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//td)[1]")
	WebElement roleCell;
	@FindBy(xpath = "//select[@class='form-control input-sm']")
	WebElement entrynum;
	@FindBy(xpath="//tr[@class='odd' or @class='even']")
	List<WebElement> rolesList;
	@FindBy(xpath = "(//a[@class='btn btn-xs btn-primary'])[3]")
	WebElement editRole;
	/*
	 * @FindBy(xpath = "//div[@id='roles_table_info']") WebElement tableInfoField;
	 */
	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[1]")
	WebElement selectCheckBox;
	@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
	WebElement updateRoleButton;
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//td)[7]")
	WebElement searchEditedElement;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
	WebElement addSalesCommissionButton;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstNameSalesCommissionAgent;
	@FindBy(xpath = "(//input[@class='form-control'])[6]")
	WebElement salesCommissionPercetage;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveSalesCommissionAgentbutton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchSalesCommissionAgent;
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//td)[1]")
	WebElement nameCellOfSalesCommissionAgent;
	@FindBy(xpath = "//button[@class='btn btn-xs btn-modal btn-primary']")
	WebElement editSalesCommissionAgentButton;
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement editAddressOfSalesCommissionAgent;
	
	
	public QaLegendUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement addUserBtn()
	{
		return(addUserButton);//another method for calling an element
	}
	public QaLegendUserPage addUserString(String sname, String mail, String pword )
	{
		Pageutilities.enterText(firstName, sname);
		Pageutilities.enterText(email, mail);
		Pageutilities.enterText(password, pword);
		Pageutilities.enterText(confirmPassword, pword);
		Pageutilities.clickOnAnElement(saveButton);
		return this; //due to "return this", public "QaLegendUserPage" addUserString(S
		 
	}
	public void searchUser(String emailId)
	{
		Pageutilities.clearText(searchUserTextBox);
		searchUserTextBox.sendKeys(emailId);
	}
	public String userNameSearch()
	{
		String name = Pageutilities.getText(nameCell);
		return name;
	}
	public QaLegendUserPage deleteUser()
	{
		Pageutilities.clickOnAnElement(userDeleteButton);
		Pageutilities.clickOnAnElement(deleteOkButton);
		return this;
	}
	public String getTableStatus()
	{
		return(Pageutilities.getText(emptyTable));
	}
	public WebElement addRoleBtn()
	{
		return(addRoleButton);
	}
	public void addRoleName(String rolename)
	{
		Pageutilities.enterText(roleNameField, rolename);
	}
	public void scrollBarRole()
	{
		Pageutilities.scrollTillElementVisible(saveRoleButton, driver);
	}
	public void saveRoleBtn()
	{
		Pageutilities.clickOnAnElement(saveRoleButton);
	}
	public void searchRole(String roname)
	{
		Pageutilities.clearText(searchRoleBox);
		searchRoleBox.sendKeys(roname);
	}
	public String roleNameSearch()
	{
		String rname = Pageutilities.getText(roleCell);
		return rname;
	}
	public void entryFieldSelect()
	{
		Pageutilities.clickOnAnElement(entrynum);
		Pageutilities.selectByValue(entrynum, "100");
		Pageutilities.clickOnAnElement(entrynum);//to close drawer menu of the entries list
		//Waitutilities.waitTillClosingTheTab(driver, entrynum);
	}
	public int rolesSizeFinder()
	{
		return(rolesList.size());
	}

	/*
	 * public void tableInfo() {
	 * Pageutilities.scrollTillElementVisible(tableInfoField, driver); }
	 */
	public void editRole()
	{
		Pageutilities.clickOnAnElement(editRole);
	}
	public void selectCheckBox()
	{
		Pageutilities.clickOnAnElement(selectCheckBox);
	}
	public void scrollBarForEdit()
	{
		Pageutilities.scrollTillElementVisible(updateRoleButton, driver);
	}
	public void updateRoleBtn()
	{
		Waitutilities.waitForClickingElement(updateRoleButton, driver);
		Pageutilities.clickOnAnElement(updateRoleButton);
	}
	public String searchEditedRole()
	{
		String ename = Pageutilities.getText(searchEditedElement);
		Waitutilities.waitForTextToBePresentInElement(searchEditedElement, driver, ename);
		return ename;
	}
	public WebElement addsalesCommissionBtn()
	{
		return(addSalesCommissionButton);
	}
	public void firstNameOfSalesCommissionAgent(String firstNameSCA) 
	{
		Pageutilities.enterText(firstNameSalesCommissionAgent, firstNameSCA);
	}
	public void salesCommissionPercentageField(String salesCommissionPercent)
	{
		Pageutilities.enterNumber(salesCommissionPercetage, salesCommissionPercent);
	}
	public void saveSalesCommissionAgentBtn()
	{
		Waitutilities.waitForClickingElement(saveSalesCommissionAgentbutton, driver);
		Pageutilities.clickOnAnElement(saveSalesCommissionAgentbutton);
		Waitutilities.waitForElementtobeInvisible(driver, saveSalesCommissionAgentbutton);
	}
	public void searchSalesCommissionAgent(String fname)
	{
		Pageutilities.clearText(searchSalesCommissionAgent);
		searchSalesCommissionAgent.sendKeys(fname);
		Waitutilities.waitForVisibilityOfElement(searchSalesCommissionAgent, driver);
	}
	public String salesCommissionAgentInTable()
	{
		Waitutilities.waitForVisibilityOfElement(nameCellOfSalesCommissionAgent, driver);
		String fNameSalesCommissionAgent = Pageutilities.getText(nameCellOfSalesCommissionAgent);
		return fNameSalesCommissionAgent;
	}
	public QaLegendUserPage editSalesCommissionAgent()
	{
		Pageutilities.clickOnAnElement(editSalesCommissionAgentButton);
		Waitutilities.waitForClickingElement(editSalesCommissionAgentButton, driver);
		return this;
	}
	public void editAddressOfSalesCommissionAgent(String address)
	{
		Pageutilities.enterText(editAddressOfSalesCommissionAgent, address);
		//Waitutilities.waitForTextToBePresentInElement(editAddressOfSalesCommissionAgent, driver, address);
		Waitutilities.waitForVisibilityOfElement(editAddressOfSalesCommissionAgent, driver);
	}
	public void updateSalesCommissionAgentBtn()
	{
		Waitutilities.waitForClickingElement(saveSalesCommissionAgentbutton, driver);
		Pageutilities.clickOnAnElement(saveSalesCommissionAgentbutton);
	}

}
