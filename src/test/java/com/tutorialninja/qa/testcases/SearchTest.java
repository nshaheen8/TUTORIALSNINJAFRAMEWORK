package com.tutorialninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialninja.qa.pages.LandingPage;
import com.tutorialninja.qa.testData.SearchTestData;
import com.tutorialninja.qa.testData.SupplyTestData;
import com.tutorialninja.qa.testbase.TestBase;

public class SearchTest extends TestBase {
	public SearchTest() throws Exception {
		super();
		
	}
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public Select select;
	
	
	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
	}
	@Test(priority=1 ,dataProvider = "TutorialNinjaDataProviderSearch" , dataProviderClass = com.tutorialninja.qa.testData.SearchTestData.class)
	public void enterSearchField(String productname) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(productname);
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys("car");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		String actualAvailableMessage = driver.findElement(By.id("content")).getText();
		Thread.sleep(1000);
		String expectedAvailableMessage = "Search - productname";
		//String expectedAvailableMessage = "Search - car";
		Thread.sleep(1000);
		softassert.assertTrue(actualAvailableMessage.contains(expectedAvailableMessage));
		Thread.sleep(1000);
		select = new Select(driver.findElement(By.xpath("//select[@class ='form-control']")));
		Thread.sleep(1000);
		select.selectByVisibleText(productname);
		//select.selectByVisibleText("Desktops");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
