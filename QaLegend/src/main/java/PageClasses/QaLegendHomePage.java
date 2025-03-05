package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;

public class QaLegendHomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagementButton;
	@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span")
	WebElement userButton;
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	WebElement endTourButton;
	@FindBy(xpath = "//span[text()='Contacts']")
	//@FindBy(xpath = "(//i[@class='fa fa-address-book']//following-sibling::span)[1]")
	WebElement contactbutton;
	//@FindBy(xpath = "//li[@class='active']")
	@FindBy(xpath = "//i[@class='fa fa-star']")
	WebElement supplierbutton;
	@FindBy(xpath = "(//span[@class='title'])[3]")
	WebElement rolesButton;
	@FindBy(xpath = "(//span[@class='title'])[4]")
	WebElement salesCommissionButton;
	
	public QaLegendHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnAnUserManagementButton()
	{
		Pageutilities.clickOnAnElement(userManagementButton); //3rd method static method was called from page utilities class
	}
	public void clickOnUserButton()
	{
		userButton.click(); //method called directly in page class
	}
	public void endTourButtonClick()
	{
		try 
		{
			endTourButton.click();
		}catch(Exception e)
		{
			System.out.println("End tour button is not visible");
		}
	}
	public void clickOnContactsBtn()
	{
		Pageutilities.clickOnAnElement(contactbutton);
	}
	public void clickOnSupplierBtn()
	{
		supplierbutton.click();
	}
	public void clickOnRolesBtn()
	{
		rolesButton.click();
	}
	public void clickOnSalesCommissionAgent()
	{
		salesCommissionButton.click();
	}

}
