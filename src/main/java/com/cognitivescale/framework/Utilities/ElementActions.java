/**
 * @author Abhishek Singh
 * 
 */
package com.cognitivescale.framework.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognitivescale.framework.common.Base;

public class ElementActions extends Base {

	// public WebDriver driver;
	
	public WebDriverWait wait;
	private static final int GLOBAL_WAIT = 45;

	/*
	 * public ElementActions(){ driver=getDriver(); }
	 */

	// FacebookSignUpPage facebookSignUpPage;
	public void inputData(WebElement element, WebDriver driver, String firstName) {

		waitForElementVisibility(driver, element);

		element.sendKeys(firstName);

	}

	public void waitForElementClicable(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, GLOBAL_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("end of  waitForElementVisibility ");

	}

	public void jsExecutorClick(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, GLOBAL_WAIT);
		waitForElementClicable(driver, element);
		System.out.println("waitForElementClicable run");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click", element);

	}
	
	public void actionClassClick(WebElement element, WebDriver driver){
		waitForElementClicable(driver, element);
		new Actions(driver).moveToElement(element).doubleClick().perform();
		
	}

	public void drodownValueSelection(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	public void screenshotcaptureAndSave(String filename, WebDriver driver) throws IOException {
		
		Date date = new Date();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		String path = "D:\\EclipseWorkSpaceNew\\com.cognitivescale.test\\Screenshots\\" + filename + ".png";
		File destinationPath = new File(path);
		FileUtils.copyFile(sourceFile, destinationPath);

	}

}
