package com.tutorialninja.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialninja.qa.pages.LandingPage;
import com.tutorialninja.qa.pages.RegisterAccountPage;
import com.tutorialninja.qa.pages.SuccessPage;
import com.tutorialninja.qa.testbase.TestBase;
import com.tutorialninja.qa.utils.Utilities;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	
	public void setUp() throws InterruptedException {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
        LandingPage landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountLink();
		//driver.findElement(By.linkText("My Account")).click();
		landingpage.clickOnRegisterLink();
		//driver.findElement(By.linkText("Register")).click();
	}
	
	@Test(priority =1)
	public void enterAllValidFields() throws InterruptedException {
		
		RegisterAccountPage registeraccountpage = new RegisterAccountPage(driver);
		registeraccountpage.enterFirstName(dataprop.getProperty("firstName"));
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		registeraccountpage.enterLastName(dataprop.getProperty("lastName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		
		registeraccountpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(Utilities.generateEmailWithTimeStamp());
		
		registeraccountpage.enterTelephone(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("validUsername"));
		registeraccountpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	    registeraccountpage.enterConfirmPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		registeraccountpage.clickRadioButtonClick();
		//driver.findElement(By.className("radio-inline")).click();
		registeraccountpage.clickAgree();
		//driver.findElement(By.name("agree")).click();
		registeraccountpage.clickContinue();
		//driver.findElement(By.xpath("//input[@class ='btn btn-primary']")).click();
		
		SuccessPage succespage = new SuccessPage(driver);
		String actualAvailableMessage = succespage.retrieveSuccessMessageText();
		//String actualAvailableMessage = driver.findElement(By.id("content")).getText();
		
		String expectedAvailableMessage = dataprop.getProperty("successAvailibiltyMessage");
		softassert.assertTrue(actualAvailableMessage.contains(expectedAvailableMessage));
		
		//Assert.assertEquals(actualAvailableMessage, expectedAvailableMessage);
		softassert.assertAll();
	}

	@Test(priority =2)
	public void enterSameCredentialsAllValidFields() {
		RegisterAccountPage registeraccountpage = new RegisterAccountPage(driver);
		registeraccountpage.enterFirstName(dataprop.getProperty("firstName"));
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		registeraccountpage.enterLastName(dataprop.getProperty("lastName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		registeraccountpage.enterEmailAddress(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
		registeraccountpage.enterTelephone(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("validUsername"));
		registeraccountpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		registeraccountpage.enterConfirmPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		registeraccountpage.clickRadioButtonClick();
		//driver.findElement(By.className("radio-inline")).click();
		registeraccountpage.clickAgree();
		//driver.findElement(By.name("agree")).click();
		registeraccountpage.clickContinue();
		//driver.findElement(By.xpath("//input[@class ='btn btn-primary']")).click();
		String actualAvailableMessage = registeraccountpage.retrieveTemporaryRegisterAlertMessageText();
		//String actualAvailableMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedAvailableMessage = dataprop.getProperty("failRegistrationMessage");
		softassert.assertTrue(actualAvailableMessage.contains(expectedAvailableMessage));
		softassert.assertAll();
		

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
