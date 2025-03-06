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
	}
	public String supplierNameSearch()
	{
		String sname = Pageutilities.getText(supplierNameCell);
		Waitutilities.waitForVisibilityOfElement(supplierNameCell, driver);
		return sname;
	}
	public void clickActionBtn()
	{
		Pageutilities.clickUsingJavaScriptExecuter(actionButton, driver);
		Waitutilities.waitForVisibilityOfElement(actionButton, driver);
	}
	public void clickOnDeleteBtn() throws InterruptedException
	{
		Pageutilities.clickOnAnElement(deleteSupplierButton);
		Thread.sleep(3000);
		Pageutilities.clickOnAnElement(deleteOkSupButton);
	}
	public String getsupplierTableStatus()
	{
		return(Pageutilities.getText(emptySupTable));
	}
	public void clickOnEditBtn()
	{
		Pageutilities.clickOnAnElement(editSupplierButton);
		Waitutilities.waitForVisibilityOfElement(editSupplierButton, driver);
	}
	public void clickOnUpdateBtn()
	{
		Pageutilities.clickOnAnElement(updateSupplierButton);
	}
	public void contactSupplierBox(String conid)
	{
		//Pageutilities.clearText(contactIdSupplierButton);
		Pageutilities.enterText(contactIdSupplierButton, conid);
	}
	public void editSupplierBusinessName(String businessName) 
	{
		updateSupBNameButton.clear();
		updateSupBNameButton.sendKeys(businessName);
		Waitutilities.waitForElementtobeInvisible(driver, updateSupplierButton);
	}
	
}
