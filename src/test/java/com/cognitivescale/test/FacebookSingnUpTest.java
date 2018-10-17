/**
 * @author Abhishek Singh
 * 
 */
package com.cognitivescale.test;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cognitivescale.framework.Utilities.ElementActions;
import com.cognitivescale.framework.businessLogic.FacebookSignUpPage;
import com.cognitivescale.framework.common.Base;

public class FacebookSingnUpTest extends Base {
	private static FacebookSignUpPage facebookSignUpPage;
	ElementActions elementActions = new ElementActions();

	@BeforeClass
	public void launchApplication() {
		System.out.println("inside launchApplication");

		facebookSignUpPage = new FacebookSignUpPage();

	}

	@Test
	public void facebookSignUPForm() throws InterruptedException, IOException {
		try {
			// String randomName=RandomStringUtils.randomAlphabetic(8);
			facebookSignUpPage.setFirstName(getConfig("firstName"));
			facebookSignUpPage.setSurName(getConfig("surName"));
			facebookSignUpPage.setUserEmail(getConfig("userEmail"));
			facebookSignUpPage.setUserEmailConfirmation(getConfig("userEmailConfirmation"));

			facebookSignUpPage.setPassword(getConfig("password"));
			facebookSignUpPage.setBirthdayDate(getConfig("birthdayDate"));
			facebookSignUpPage.setBirthdayMonth(getConfig("birthdayMonth"));
			facebookSignUpPage.setBirthdayYear(getConfig("birthdayYear"));
			facebookSignUpPage.setGenderRadioButton();
			facebookSignUpPage.setSignUPButton();

		} catch (Exception exe) {
			System.out.println("Execption details are  " + exe);
		}

	}

}
