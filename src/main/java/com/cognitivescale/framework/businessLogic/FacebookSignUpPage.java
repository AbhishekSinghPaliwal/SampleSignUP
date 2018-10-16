package com.cognitivescale.framework.businessLogic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cognitivescale.framework.Utilities.ElementActions;
import com.cognitivescale.framework.common.Base;

public class FacebookSignUpPage {

	WebDriver driver;

	// ElementActions elementActions;
	ElementActions elementActions = new ElementActions();
	// ElementActions elementActions=new ElementActions();

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement surName;

	@FindBy(xpath = "//input[contains(@name,'reg_email')]")
	private WebElement userEmail;// userEmailConfirmation

	@FindBy(xpath = "//input[contains(@name,'reg_email_confirmation')]")
	private WebElement userEmailConfirmation;

	@FindBy(xpath = "//input[contains(@name,'reg_passwd')]")
	private WebElement password;

	@FindBy(id = "day")
	private WebElement birthdayDate;

	@FindBy(id = "month")
	private WebElement birthdayMonth;

	@FindBy(id = "year")
	private WebElement birthdayYear;

	@FindBy(id = "u_0_a")
	private WebElement genderRadioButton;

	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement signUPButton;

	public FacebookSignUpPage() {
		PageFactory.initElements(Base.getDriver(), this);
		driver = Base.getDriver();

	}

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws InterruptedException {

		// elementActions=new ElementActions();

		System.out.println("inside setFirstName");
		elementActions.inputData(this.firstName, driver, firstName);

	}

	public WebElement getSurName() {
		return surName;
	}

	public void setSurName(String surName) {

		elementActions.inputData(this.surName, driver, surName);

	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		elementActions.inputData(this.userEmail, driver, userEmail);
	}

	public WebElement getUserEmailConfirmation() {
		return userEmailConfirmation;
	}

	public void setUserEmailConfirmation(String userEmailConfirmation) {

		elementActions.inputData(this.userEmailConfirmation, driver, userEmailConfirmation);
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String password) {
		elementActions.inputData(this.password, driver, password);
	}

	public WebElement getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(String birthdayDate) {
		elementActions.drodownValueSelection(this.birthdayDate, birthdayDate);

	}

	public WebElement getBirthdayMonth() {
		return birthdayMonth;
	}

	public void setBirthdayMonth(String birthdayMonth) {
		// this.birthdayMonth = birthdayMonth;
		elementActions.drodownValueSelection(this.birthdayMonth, birthdayMonth);

	}

	public WebElement getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(String birthdayYear) throws IOException {
		elementActions.drodownValueSelection(this.birthdayYear, birthdayYear);
		elementActions.screenshotcaptureAndSave("fileName", driver);
	}

	public WebElement getGenderRadioButton() {
		return genderRadioButton;
	}

	public void setGenderRadioButton(String genderRadioButton) {

		// elementActions.inputData(this.genderRadioButton,password);
	}

	public WebElement getSignUPButton() {
		return signUPButton;
	}

}
