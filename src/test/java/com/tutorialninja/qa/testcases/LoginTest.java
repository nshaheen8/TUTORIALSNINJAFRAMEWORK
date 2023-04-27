package com.tutorialninja.qa.testcases;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialninja.qa.pages.AccountPage;
import com.tutorialninja.qa.pages.LandingPage;
import com.tutorialninja.qa.pages.LoginPage;
import com.tutorialninja.qa.testData.SupplyTestData;
import com.tutorialninja.qa.testbase.TestBase;
import com.tutorialninja.qa.utils.Utilities;

public class LoginTest extends TestBase{
	public LoginTest() throws Exception {
		super();
		
	}

	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		LandingPage landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountLink();
		landingpage.clickOnLoginLink();
		//driver.findElement(By.linkText("My Account")).click();
		//driver.findElement(By.linkText("Login")).click();
		
		
	}

	@Test(priority=1 ,dataProvider = "NinjaTutorialExcelDataWithDataProvider" , dataProviderClass = SupplyTestData.class)
	public void verifyNinjaTutorialLoginWithValidUsernameAndValidPassword(String username, String password) {

		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterEmailAddress(username);
		//driver.findElement(By.id("input-email")).sendKeys(username);
		
		loginpage.enterPassword(password);
		//driver.findElement(By.id("input-password")).sendKeys(password);
		
		loginpage.clickLogin();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		AccountPage accountpage = new AccountPage(driver);
		softassert.assertTrue(accountpage.accountLinkDisplayedOrnot());
		//softassert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Edit your account information' )]")).isDisplayed());
		softassert.assertAll();
		
	}
	@Test(priority=2)
	public void verifyNinjaTutorialLoginWithInvalidUsernameAndInvalidPassword() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidpassword"));
		loginpage.clickLogin();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		AccountPage accountpage = new AccountPage(driver);
		String actualWarningMessage = accountpage.retrieveTemporaryAlertMessageText();
		
		//softassert.assertTrue(false);
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is not correct");
		softassert.assertAll();
		
	}
	@Test(priority=3)
	public void verifyNinjaTutorialLoginWithValidUsernameAndInvalidPassword() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
		loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidpassword"));
		loginpage.clickLogin();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		AccountPage accountpage = new AccountPage(driver);
		String actualWarningMessage = accountpage.retrieveTemporaryAlertMessageText();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is not correct");
		softassert.assertAll();
		
	}
	@Test(priority=4)
	public void verifyNinjaTutorialLoginWithEmptyUsernameAndvalidPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		loginpage.clickLogin();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		AccountPage accountpage = new AccountPage(driver);
		String actualWarningMessage = accountpage.retrieveTemporaryAlertMessageText();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is not correct");
		softassert.assertAll();
		
	}
	@Test(priority=5)
	public void verifyNinjaTutorialLoginWithValidUsernameAndEmptyPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
		loginpage.clickLogin();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		AccountPage accountpage = new AccountPage(driver);
		String actualWarningMessage = accountpage.retrieveTemporaryAlertMessageText();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is not correct");
		softassert.assertAll();
		
	}
	@Test(priority=6)
	public void verifyNinjaTutorialLoginWithEmptyUsernameAndEmptyPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickLogin();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		AccountPage accountpage = new AccountPage(driver);
		String actualWarningMessage = accountpage.retrieveTemporaryAlertMessageText();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning Message is not correct");
		softassert.assertAll();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
