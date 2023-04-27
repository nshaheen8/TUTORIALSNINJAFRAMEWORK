package com.tutorialninja.qa.utils;

import java.util.Date;

public class Utilities {
	
	public static final int scriptTime = 100;
	public static final int implicitWaitTime = 10;
	public static final int pageLoadTime = 10;


	public static void main(String[] args) {
		generateEmailWithTimeStamp();
	}
	
	public static String generateEmailWithTimeStamp() {
	Date date = new Date();
	String timeStamp = date.toString().replace(" ", "_").replace(":", "_").substring(8, 19).replace("_", "");
	//String timeStamp = (date.toString().replace(" ", "_").replace(":", "_").trim().substring(4).trim().substring(0,15).concat("_2023"));
	return "nshaheen" + timeStamp + "@gmail.com";

}
	//public static String generateNameforEmailWithTimeStamp() {
		//Date date = new Date();
		//String timeStamp = date.toString().replace(" ", "_").replace(":", "_").substring(8,19).replace("_", "");
		//System.out.println(timeStamp);
		//String timeStamp1 = timeStamp.substring(8,19).replace("_", "");
		//System.out.println(timeStamp1);
		//return "nshaheen" + timeStamp + "@gmail.com";
		
	}


	//public static final int implicitWaitTime = 10;
	//public static final int pageLoadTime = 10;
	//public static final int scriptTime = 100;
	
//}