package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
public WebDriver driver;
	
	//Objects
	@FindBy(id = "content")
	private WebElement successText;
	
	
	
	public SuccessPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}
	public String retrieveSuccessMessageText() {
		String SuccessMessage = successText.getText();
		return SuccessMessage;
}
		
	}
	


