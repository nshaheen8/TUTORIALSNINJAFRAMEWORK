package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	//Objects
	@FindBy(id = "input-email")
	private WebElement emailaddressTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginTextBox;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void enterEmailAddress(String emailaddressText) {
		
		emailaddressTextBox.sendKeys(emailaddressText);
	}
   public void enterPassword(String passwordText) {
		
	passwordTextBox.sendKeys(passwordText);
	
	
	}
   public void clickLogin() {
		
	   loginTextBox.click();
	
   }
}
