package com.cognitivescale.framework.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognitivescale.framework.common.Base;

public class ElementActions extends Base{
	
	//public WebDriver driver;
	public static int count=1;
	public WebDriverWait wait;
	private static final int GLOBAL_WAIT = 90;
	
	
	/*public ElementActions(){
		driver=getDriver();
	}*/

	//FacebookSignUpPage facebookSignUpPage;
	public void inputData(WebElement element,WebDriver driver,String firstName){
		
		waitForElementVisibility(element,driver);
		
		
		element.sendKeys(firstName);
		
		
	}
	
	public void waitForElementVisibility(WebElement element,WebDriver driver){
		wait=new WebDriverWait(driver, GLOBAL_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("end of  waitForElementVisibility ");
		
		
		
	}
	
	public void drodownValueSelection(WebElement element,String value){
		new Select(element).selectByValue(value);
	}
	
	/*public void waitForPageLoad(WebDriver driverObj){
		driverObj.manage().timeouts().implicitlyWait(GLOBAL_WAIT, TimeUnit.SECONDS);
		
		
		
		
	}*/
	
	public void screenshotcaptureAndSave(String filename,WebDriver driver) throws IOException{
		count=count+1;
		Date date=new Date();
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
//		String path="D:\\EclipseWorkSpaceNew\\com.cognitivescale.test\\Screenshots\\"+filename+"+date+"+".png";
		String path="D:\\EclipseWorkSpaceNew\\com.cognitivescale.test\\Screenshots\\"+filename+".png";
		File destinationPath=new File(path);
		FileUtils.copyFile(sourceFile, destinationPath);
		
	}

}