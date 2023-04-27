package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
 
	public WebDriver driver;
	
	//Objects
	@FindBy(xpath = "//a[contains(text(), 'Edit your account information')]")
	private WebElement accountLink;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertmessage;
	
	
	
	public AccountPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}
	public boolean accountLinkDisplayedOrnot() {
	boolean displayStatus = accountLink.isDisplayed();
	return displayStatus;
		
	}
	public String retrieveTemporaryAlertMessageText() {
		String TemporaryAlertMessage = alertmessage.getText();
		return TemporaryAlertMessage;
}
}