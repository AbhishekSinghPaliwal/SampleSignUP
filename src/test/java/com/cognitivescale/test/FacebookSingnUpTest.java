package com.cognitivescale.test;



import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cognitivescale.framework.Utilities.ElementActions;
import com.cognitivescale.framework.businessLogic.FacebookSignUpPage;
import com.cognitivescale.framework.common.Base;



public class FacebookSingnUpTest extends Base{
	private static FacebookSignUpPage facebookSignUpPage;
	ElementActions elementActions=new ElementActions();
	WebDriver driver;
	//public FacebookSignUpPage facebookSignUpPage;
	//Base base=new Base();
	
	@BeforeClass
	public void launchApplication(){
		System.out.println("inside launchApplication");
		//driver=getDriver();
		facebookSignUpPage=new FacebookSignUpPage();
		
	}
	
	@Test
	public void facebookSignUPForm() throws InterruptedException, IOException{
		//String randomName=RandomStringUtils.randomAlphabetic(8);
		facebookSignUpPage.setFirstName(getConfig("firstName"));
		facebookSignUpPage.setSurName(getConfig("surName"));
		facebookSignUpPage.setUserEmail(getConfig("userEmail"));
		facebookSignUpPage.setUserEmailConfirmation(getConfig("userEmailConfirmation"));
		
		facebookSignUpPage.setPassword(getConfig("password"));
		facebookSignUpPage.setBirthdayDate(getConfig("birthdayDate"));
		facebookSignUpPage.setBirthdayMonth(getConfig("birthdayMonth"));
		facebookSignUpPage.setBirthdayYear(getConfig("birthdayYear"));
		
		
		
	}
	
	

}
