package com.tutorialninja.qa.testbase;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tutorialninja.qa.utils.Utilities;

public class TestBase {
    public static WebDriver driver;
    public static  Properties prop;
    public static Properties dataprop;
    public static FileInputStream ip;
    public static ChromeOptions options;
    //static String projectPath = System.getProperty("user.dir");

	public TestBase() throws Exception {
	    prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties");
		prop.load(ip);
		
		dataprop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\testData\\testData.properties");
		dataprop.load(ip);
	}

	public  WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicitWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadTime));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.scriptTime));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
}
