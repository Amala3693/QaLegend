package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import Utilities.Pageutilities;
import Utilities.Waitutilities;

public class QaLegendContactsPage {
	WebDriver driver;
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addSupplierButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement contactName;
	@FindBy(xpath = "//input[@id='supplier_business_name']")
	WebElement supplierBusinessName;
	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobileNumber;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement supplierSaveButton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchSupplierBox;
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//td)[3]")
	WebElement supplierNameCell;
	@FindBy(xpath = "//button[@class='btn btn-info dropdown-toggle btn-xs']")
	WebElement actionButton;
	@FindBy(xpath = "//a[@class='delete_contact_button']")
	WebElement deleteSupplierButton;
	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deleteOkSupButton;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement emptySupTable;
	@FindBy(xpath = "//a[@class='edit_contact_button']")
	WebElement editSupplierButton;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement updateSupplierButton;
	@FindBy(xpath = "//input[@id='contact_id']")
	WebElement contactIdSupplierButton;
	@FindBy(xpath = "//input[@id='supplier_business_name']")
	WebElement updateSupBNameButton;
	
	
	
	
	
	public QaLegendContactsPage(WebDriver driver)	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement addSupplierBtn()
	{
		return(addSupplierButton);
	}
	public QaLegendContactsPage addSupplierString(String suname, String subname, String mobnum)
	{
		Pageutilities.enterText(contactName, suname);
		Pageutilities.enterText(supplierBusinessName, subname);
		//Pageutilities.enterNumber(mobileNumber, mobnum);
		Pageutilities.enterText(mobileNumber, mobnum);
		Pageutilities.clickOnAnElement(supplierSaveButton);
		Waitutilities.waitForElementtobeInvisible(driver, supplierSaveButton);
		return this;
	}
	public void searchSupplier(String suname)
	{
		Pageutilities.clearText(searchSupplierBox);
		searchSupplierBox.sendKeys(suname);
		Waitutilities.waitForVisibilityOfElement(searchSupplierBox, driver);
	}
	public String supplierNameSearch()
	{
		//Waitutilities.waitForVisibilityOfElement(supplierNameCell, driver);
		//Waitutilities.waitForElementToBeSelected(supplierNameCell, driver);
		String sname = Pageutilities.getText(supplierNameCell);
		Waitutilities.waitForVisibilityOfElement(supplierNameCell, driver);
		
		return sname;
	}
	public void clickActionBtn()
	{
		Waitutilities.waitForClickingElement(actionButton, driver);
		Pageutilities.clickUsingJavaScriptExecuter(actionButton, driver);
	}
	public void clickOnDeleteBtn() throws InterruptedException
	{
		Waitutilities.waitForClickingElement(deleteSupplierButton, driver);
		Pageutilities.clickOnAnElement(deleteSupplierButton);
		Pageutilities.clickOnAnElement(deleteOkSupButton);
		//Waitutilities.waitForClickingElement(deleteOkSupButton, driver);
		Waitutilities.waitForElementtobeInvisible(driver, deleteOkSupButton);
	}
	public String getsupplierTableStatus()
	{
		return(Pageutilities.getText(emptySupTable));
	}
	public void clickOnEditBtn()
	{
		Waitutilities.waitForVisibilityOfElement(editSupplierButton, driver);
		Waitutilities.waitForClickingElement(editSupplierButton, driver);
		Pageutilities.clickOnAnElement(editSupplierButton);
	}
	public void clickOnUpdateBtn()
	{
		Waitutilities.waitForClickingElement(updateSupplierButton, driver);
		Pageutilities.clickOnAnElement(updateSupplierButton);
		Waitutilities.waitForElementtobeInvisible(driver, updateSupplierButton);
	}
	public void contactSupplierBox(String conid)
	{
		//Pageutilities.clearText(contactIdSupplierButton);
		Waitutilities.waitForVisibilityOfElement(contactIdSupplierButton, driver);
		Pageutilities.enterText(contactIdSupplierButton, conid);
	}
	public void editSupplierBusinessName(String businessName) 
	{
		Waitutilities.waitForVisibilityOfElement(updateSupBNameButton, driver);
		updateSupBNameButton.clear();
		updateSupBNameButton.sendKeys(businessName);
		//Waitutilities.waitForTextToBePresentInElement(updateSupBNameButton, driver, businessName);
	}
	
}
