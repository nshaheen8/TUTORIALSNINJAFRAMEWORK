package com.tutorialninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReporter {
public static ExtentReports  generateExtentReport() throws Exception {
	//Step 1 - create object of ExtentReports
	
	ExtentReports extentReport = new ExtentReports();
	
	//Step 2 - create the folder in test-output and pass the extentReport as an html file
	File extentReportFile = new File (System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
	
	//Step 3- create the Object of ExtentSparkReporter
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);//sparkReporter will help us set configarations
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("TUTORIALSNINJA TEST RESULTS");
	sparkReporter.config().setDocumentTitle("TUTORIALSNINJA TEST");
	sparkReporter.config().setTimeStampFormat("MM/DD/YYYY hh:mm:ss");
	
	extentReport.attachReporter(sparkReporter);
	
	Properties configProp = new Properties();
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties");
	configProp.load(ip);
	
	extentReport.setSystemInfo("Application url", configProp.getProperty("url"));
	extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
	extentReport.setSystemInfo("UserName", configProp.getProperty("validUsername"));
	extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
	extentReport.setSystemInfo("Operating System", configProp.getProperty("os.version"));
	extentReport.setSystemInfo("Tester Name", configProp.getProperty("user.name"));
	extentReport.setSystemInfo("Java Version", configProp.getProperty("java.version"));
	
	return extentReport;
	
}
}
