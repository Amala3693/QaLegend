package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Pageutilities {
	//Generic methods
	WebDriver driver;
	public static void clickOnAnElement(WebElement element)
	{
		element.click();
	}
	public static void selectByValue(WebElement element, String value) 
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element, int index) 
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public static void enterText(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	public static void dragAndDrop(WebElement source, WebElement destination, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
	public static void rightClickOnAnElement(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public static void rightClick(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.contextClick().build().perform();
	}
	public static void mouseOver(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public static void clickUsingJavaScriptExecuter(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public static void scrollTillElementVisible(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static boolean isElementVisisble(WebElement element)
	{
		return(element.isDisplayed());
	}
	public static boolean isElemenetEnabled(WebElement element)
	{
		return(element.isEnabled());
	}
	public static String getText(WebElement element)
	{
		String text = element.getText();
		return(text);
	}
	@SuppressWarnings("deprecation")
	public static String getAttribute(WebElement element, String attributeName)
	{
		return(element.getAttribute(attributeName));
	}
	public static void navigateTo(WebDriver driver, String url)
	{
		driver.navigate().to(url);
	}
	public static void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	public static void forward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public static void refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static void clearText(WebElement element)
	{
		element.clear();
	}
	public static void enterNumber(WebElement element, String num)
	{
		element.sendKeys(num);
	}
	public static void closeTab(WebDriver driver)
	{
		driver.close();
	}

}
