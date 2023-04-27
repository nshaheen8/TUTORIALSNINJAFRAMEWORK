package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	public WebDriver driver;
	//Objects
	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;
	@FindBy(id = "input-lastname")
	private WebElement lastNameTextBox;
	@FindBy(id = "input-email")
	private WebElement emailaddressTextBox;
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;
	@FindBy( className = "radio-inline")
	private WebElement radioClick;
	@FindBy(name = "agree")
	private WebElement agreeClick;
	@FindBy(xpath = "//input[@class ='btn btn-primary']")
	private WebElement continueClick;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement registeralertmessage;
	
	public RegisterAccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterFirstName(String firstNameText) {
		firstNameTextBox.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameTextBox.sendKeys(lastNameText);
}
	public void enterEmailAddress(String emailaddressText) {
	emailaddressTextBox.sendKeys(emailaddressText);
}
	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
	}
	public void clickRadioButtonClick() {
		radioClick.click();
	}
	public void clickAgree() {
		agreeClick.click();
	}
	public void clickContinue() {
		continueClick.click();
	}
	public String retrieveTemporaryRegisterAlertMessageText() {
		String TemporaryRegisterAlertMessage = registeralertmessage.getText();
		return TemporaryRegisterAlertMessage;
}
}
