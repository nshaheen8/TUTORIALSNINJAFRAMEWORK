package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
public WebDriver driver;	

@FindBy(linkText = "My Account")	
private WebElement myaccounttLink	;
	
@FindBy(linkText = "Login")
private WebElement loginLink;

@FindBy(linkText = "Register")
private WebElement registerLink;

//@FindBy(xpath = "//input[@class='form-control input-lg']")
//private WebElement searchTextBox;

public LandingPage(WebDriver driver) {
	this.driver = driver;
	//PageFactory.initElements(driver, LandingPage.class);
	PageFactory.initElements(driver,this);
	
}
//Actions

public void clickOnMyAccountLink() {
	myaccounttLink.click();
}
public void clickOnLoginLink() {
	loginLink.click();
}
public void clickOnRegisterLink() {
	registerLink.click();
}
//public void 

}
