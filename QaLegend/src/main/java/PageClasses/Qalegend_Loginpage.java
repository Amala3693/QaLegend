package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;

public class Qalegend_Loginpage {
WebDriver driver;
@FindBy(id="username")
WebElement usernamefield;
@FindBy(id="password")
WebElement passwordfield;
@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement loginbtn;

public Qalegend_Loginpage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
} 


public void loginToQalegend(String username, String password)
{
	//usernamefield.sendKeys(username); instead of this use the below
	Pageutilities.enterText(usernamefield, username);
	//passwordfield.sendKeys(password); instead of this use the below
	Pageutilities.enterText(passwordfield, password);
	//loginbtn.click(); instead of this use the below
	Pageutilities.clickOnAnElement(loginbtn);
}








}
