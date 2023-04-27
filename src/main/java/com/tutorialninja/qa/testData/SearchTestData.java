package com.tutorialninja.qa.testData;

import java.io.FileInputStream;

import org.testng.annotations.DataProvider;

public class SearchTestData {
	public static FileInputStream ip;
    @DataProvider(name = "TutorialNinjaDataProviderSearch")
	
	public static String[] dataSearchFrom1DimensionalArray() {
		
		String[] data = new String[]{"Desktops","Laptops&Notebooks","Components","Tablets","Software","Phones&PDAs","Cameras","MP3Players"};
		
		return data;
		    
		}
}
