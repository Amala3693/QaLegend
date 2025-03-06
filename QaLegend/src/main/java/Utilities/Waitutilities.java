package Utilities;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constants;

public class Waitutilities {
	public WebDriver driver;
	public static void waitForClickingElement(WebElement element, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForTextToBePresentInElement(WebElement element, WebDriver driver, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public static void waitForElementToBeSelected(WebElement element, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void waitForVisibilityOfElement(WebElement element, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void alertWait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void attributeWait(WebElement element, WebDriver driver, String attributeValue, String attributeName)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.attributeToBe(element, attributeName, attributeValue));
	}
	public static void waitForElementtobeInvisible(WebDriver driver,WebElement element)

	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));//calling static variable from constant class
		wait.until(ExpectedConditions.invisibilityOf(element));
	}


	

}
